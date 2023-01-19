package serveur;

import service.GestionEtudiant;

import javax.xml.ws.Endpoint;

public class SoapServer {
    public static void main(String[] args) {
        String url = "http://192.168.1.17:1223/";
        Endpoint.publish(url,new GestionEtudiant());
        System.out.println("Service à l'adresse : "+url);
    }
}
