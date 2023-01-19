package domaine;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Etudiant {
    private int idEt;
    private String nom;
    private String prenom;
    private static int lastId= 1;
    public Etudiant() {}

    public Etudiant(String nom, String prenom) {
        this.idEt = lastId++;
        this.nom = nom;
        this.prenom = prenom;
    }
    public Etudiant(int id, String nom, String prenom) {
        this.idEt =id;
        this.nom=nom;
        this.prenom=prenom;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getIdEt() {
        return idEt;
    }

    @Override
    public String toString() {
        return "ID : "+getIdEt()+" Nom: "+getNom()+" Prenom: "+getPrenom();
    }
}
