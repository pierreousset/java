package com.ynov.serveur;

import com.ynov.serveur.service.TimeServer;
import org.flywaydb.core.Flyway;

import static javax.swing.SwingUtilities.invokeLater;

public class Main {
    public  static void main(String[] args) { invokeLater(Main::main); }

    private static void Connexion() {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/java", "root", "root");
        flyway.migrate();

    }

    private static void main() {

        String host = "10.31.0.222";
        int port = 2345;

        TimeServer ts = new TimeServer(host, port);
        ts.open();

        System.out.println("Serveur initialisé.");

    }
}
