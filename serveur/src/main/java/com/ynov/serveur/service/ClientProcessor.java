package com.ynov.serveur.service;

import domain.User;
import com.google.gson.Gson;
import model.UserSimple;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedInputStream;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



public class ClientProcessor implements Runnable{
    private Socket sock;
    private PrintWriter writer = null;
    private BufferedInputStream reader = null;

    public ClientProcessor(Socket pSock){
        sock = pSock;
    }

    //Le traitement lancé dans un thread séparé
    public void run(){
        System.err.println("Lancement du traitement de la connexion cliente");
        boolean closeConnexion = false;
        //tant que la connexion est active, on traite les demandes
        while(!sock.isClosed()){

            try {
                writer = new PrintWriter(sock.getOutputStream());
                reader = new BufferedInputStream(sock.getInputStream());
                //On attend la demande du client
                String response = read();
                InetSocketAddress remote = (InetSocketAddress)sock.getRemoteSocketAddress();
                //On affiche quelques infos, pour le débuggage
                String debug = "";
                debug = "Thread : " + Thread.currentThread().getName() + ". ";
                debug += "Demande de l'adresse : " + remote.getAddress().getHostAddress() +".";
                debug += " Sur le port : " + remote.getPort() + ".\n";
                debug += "\t -> Commande reçue : " + response + "\n";
                System.err.println("\n" + debug);

                //On traite la demande du client en fonction de la commande envoyée
                Requete requete;
                requete = new Requete();

                String stringReponse = response.toUpperCase();

                System.out.println("Reponse : " + stringReponse);

                JSONArray js = new JSONArray(stringReponse);
                System.out.println(js);
                JSONObject obj = new JSONObject(js.getString(1));

                String[] parts = stringReponse.split("@@");
                switch(parts[0]){
                    case "USERSELECT":
                        List<User> toSend;
                        toSend = requete.userSelect();
                        writer.write(String.valueOf(toSend));
                        break;
                    case "USERINSERT":
                        String userInsert;
                        userInsert = requete.userInsert();
                        writer.write(userInsert);
                        break;

                    case "CLOSE":
                        String close = "";
                        close = "Communication terminée";
                        closeConnexion = true;
                        writer.write(String.valueOf(close));
                        break;

                    default :
                        String toSends = "";
                        toSends = "Commande inconnu ! : " + response;
                        writer.write(String.valueOf(toSends));
                        break;
                }
                writer.flush();
                if(closeConnexion){
                    System.err.println("CLOSE");
                    writer = null;
                    reader = null;
                    sock.close();
                    break;
                }
            }catch(SocketException e){
                System.err.println("LA CONNEXION A ETE INTERROMPUE ! ");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //La méthode que nous utilisons pour lire les réponses
    private String read() throws IOException{
        String response = "";
        int stream;
        byte[] b = new byte[4096];
        stream = reader.read(b);
        response = new String(b, 0, stream);
        return response;
    }
}