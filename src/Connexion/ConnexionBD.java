package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionBD {
    public static  Connection connecter() {
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String MySQLURL = "jdbc:mysql://192.168.1.17:3306/Etudiants";
            String databseUserName = "etu";
            String databasePassword = "passer";
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

}
