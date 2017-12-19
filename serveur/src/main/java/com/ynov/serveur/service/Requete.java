package com.ynov.serveur.service;

import java.util.List;
import java.util.Map;

public class Requete {
    public List userSelect(){
        System.out.println("je suis la ");
        Connexion connection ;
        connection = new Connexion();
        List<Map<String, Object>> result = connection.main().createQuery("SELECT * FROM test")
                .list();
        return result;
    }

    public String userInsert(){
        Connexion connection ;
        connection = new Connexion();
        String userInsert;
        try {
            connection.main().execute("INSERT INTO");
            userInsert = "bon";
        }
        catch (ArithmeticException e){
            userInsert = "pas bon";
        }
        return userInsert;
    }
}
