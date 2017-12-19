package com.ynov.serveur.service;

import org.mindrot.jbcrypt.BCrypt;
import org.skife.jdbi.v2.util.StringColumnMapper;

public class Authentification {
    String sql = "SELECT psw FROM utilisateur WHERE email = ?";
    Connexion conn = new Connexion();

    public void checking (String string) {
        String hashed =  conn.main().createQuery(sql)
                                    .bind(0, string)
                                    .map(StringColumnMapper.INSTANCE)
                                    .first();

        if (BCrypt.checkpw( string , hashed)) {
            System.out.println("User authentified");
        } else {
            System.out.println("Access denied");
        }
    }
}
