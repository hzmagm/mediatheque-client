
package Model;

import java.io.Serializable;


public class Client  implements Serializable{
   private int idClient;
    private String Nom;
    private String Prenom;
    private int Age;
    private String TypeClient;
    private String CNE;
    private String CNI;
    //private int[] LesFavoris;
    public Client(String nom, String prenom, int age) {
        //super(genererUser(),genererPassword());
        this.Nom=new String(nom);
        this.Prenom=new String(prenom);
        this.setAge(age);
    }   
    public Client(Client c) {
        //super(genererUser(),genererPassword());
        this.Nom=new String(c.getNom());
        this.Prenom=new String(c.getPrenom());
        this.Age=c.getAge();
    }

    public void setTypeClient(String TypeClient) {
        this.TypeClient = TypeClient;
    }
    //Client Etudiant/prof
    public Client(int idClient, String Nom, String Prenom,String typeClient, int Age, String CN) {
        this.idClient = idClient;
        this.TypeClient=typeClient;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Age = Age;
        if("Etudiant".equals(this.TypeClient)){
            this.CNE = CN;
        }else{
            this.CNI = CN;
        }
    }
public String getTypeClient() {
        return TypeClient;
    }
    public Client(int idClient, String Nom, String Prenom, int Age) {
        this.idClient = idClient;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Age = Age;
    }
    
    public static String genererUser(){
        return "";
    }
    public static String genererPassword(){
        return "";
    }

    public String toString() {   
        //ajouter if client is etudiant or prof
        return "[Le Nom : "+this.getNom()+" | Le prenom : "+this.getPrenom()+" | L'Age : "+this.getAge()+"]";
    }

    public int getIdClient(){
        return idClient;
    }
    public String getNom() {
        return Nom;
    }
    public void setNom(String nom) {
        Nom = nom;
    }
    public String getPrenom() {
        return Prenom;
    }
    public void setPrenom(String prenom) {
        Prenom = prenom;
    }


    public int getAge() {
        return Age;
    }


    public void setAge(int age) {
        Age = age;
    }
}
