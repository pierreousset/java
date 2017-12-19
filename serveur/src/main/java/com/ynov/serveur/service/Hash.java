package com.ynov.serveur.service;

import org.mindrot.jbcrypt.BCrypt;

public class Hash {
    public String Hash (String string) {
        String toHash = BCrypt.hashpw(string, BCrypt.gensalt());
        return toHash;
    }
}
