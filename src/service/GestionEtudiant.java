package service;
import Connexion.ConnexionBD;
import domaine.Etudiant;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.sql.*;
import java.util.ArrayList;

@WebService(serviceName = "GestionEtudiant")
public class GestionEtudiant {
    @WebMethod(operationName = "ListerEtudiant")
    public ArrayList<String> lister() {
        ArrayList<String> etudiants= new ArrayList<String>();
        try {
            Connection con = ConnexionBD.connecter();
            String sql = "SELECT * FROM etudiants";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                int id = result.getInt("id");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                Etudiant e = new Etudiant(id,nom,prenom);
                etudiants.add(e.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return etudiants;
    }
    @WebMethod(operationName = "AjouterEtudiant")
    public String ajouter(@WebParam(name="prenom")String prenom, @WebParam(name="nom")String nom){
        try {
            Connection con = ConnexionBD.connecter();
            Etudiant e = new Etudiant(nom,prenom);
            String sql = "INSERT INTO etudiants (nom,prenom) VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,e.getNom());
            statement.setString(2, e.getPrenom());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return "Ajout effectue avec succes";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "Termine";
    }


    @WebMethod(operationName = "SupprimerEtudiant")
    public String supprimer(@WebParam(name="id") int id){
        try {
            Connection con = ConnexionBD.connecter();
            String sql = "DELETE FROM etudiants WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return "Suppression de l'etudiant numero "+id+" effectue avec succes";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return  "Termine";
        }
        @WebMethod(operationName = "ModifierEtudiant")
     public String modifier(@WebParam(name="id") int id,@WebParam(name="nom")String nom,@WebParam(name="prenom")String prenom) {
            try {
                Connection con = ConnexionBD.connecter();
                Etudiant e = new Etudiant(nom,prenom);
                String sql = "UPDATE etudiants SET nom=?, prenom=? WHERE id=?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, e.getNom());
                statement.setString(2, e.getPrenom());
                statement.setInt(3, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    return "Mis a jour de l'etudiant numero "+id+" effectue avec succes";
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

         return "Termine";
     }
    }

