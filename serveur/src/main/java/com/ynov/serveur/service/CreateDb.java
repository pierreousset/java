package com.ynov.serveur.service;

import com.ynov.serveur.Main;
import org.flywaydb.core.Flyway;

import static javax.swing.SwingUtilities.invokeLater;

public class CreateDb {
    public  static void main(String[] args) { invokeLater(CreateDb::main); }

    private static void main() {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/java", "root", "root");
        flyway.migrate();

    }
}
