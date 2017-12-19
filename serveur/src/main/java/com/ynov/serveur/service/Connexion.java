package com.ynov.serveur.service;

import org.skife.jdbi.v2.*;

import static javax.swing.SwingUtilities.invokeLater;

public class Connexion {

    public Handle main() {
        String url = "jdbc:mysql://localhost:3306/java";
        String utilisateur = "root";
        String motDePasse = "root";

        Handle handle = DBI.open(url, utilisateur, motDePasse);

        return handle;
    }
}
