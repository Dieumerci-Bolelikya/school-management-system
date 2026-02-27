package tests;

import database.DatabaseConnection;

public class TestConnexion {
    public static void main(String[] args) {
        System.out.println(
            DatabaseConnection.getConnection() != null
            ? "Connexion OK"
            : "Connexion échouée"
        );
    }
}