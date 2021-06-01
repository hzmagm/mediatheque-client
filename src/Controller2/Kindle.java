package Controller2;

import Model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.*;
import java.lang.Exception;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kindle {
    static boolean repeat=true;
    Client c=null;
    Kindle k;
    String hote = "127.0.0.1" ;
    int port = 1000 ;
   
    Controller cntr;
    public Kindle() {
        cntr=new Controller();
    }
    public boolean Connexion() throws IOException, ClassNotFoundException{
         String kindle=null;
         Socket soc1 = new Socket (hote, port);
         if(soc1.isConnected()){
         System.out.println("---Kindle Connecté au server---");
         }
        int i=3;
        
        while(c==null){ 
         try (Socket soc = new Socket (hote, port)){
             
            OutputStream flux1 = soc.getOutputStream() ;
            OutputStreamWriter sortie = new OutputStreamWriter (flux1) ;
            System.out.println("login :");
            String login= (new Scanner(System.in)).nextLine();
            sortie.write(login+"\n");
            System.out.println("passwd : ");
            String passwd= (new Scanner(System.in)).nextLine();
            sortie.write(passwd+"\n");
            System.out.println("Connecting...");
            sortie.flush();
            ObjectInputStream objEnt = new ObjectInputStream(soc.getInputStream());
            Object obj = objEnt.readObject();
            c=(Client)obj;
            if(c!=null){
            InputStream flux2 = soc.getInputStream();
            BufferedReader entree = new BufferedReader (new InputStreamReader (flux2));
            kindle=entree.readLine();
            }else if(c==null){
                System.out.println(" login failed ! ");
            }
            i--;
            if(i==0){
                System.out.println("--- nombre d'essayer déja consommé Kindle va s'éteint  ---");
            return false;
            }
         }
         catch(Exception e){
            System.out.println(e);
        }
            }
        if("Etudiant".equals(c.getTypeClient())){
                Thread_timelimit tr=new Thread_timelimit();
                tr.start();
        }
                System.out.println("bienvenue " + c.getNom() +" "+ c.getPrenom()+"\n ");
                System.out.println("vous ete connecté par le kindle : "+kindle+"]");
                return true;
    }
    //GETTERS DE DOCUMENT
        
    public String getDocumentByISBN(){
        
        System.out.println("---- get document by ISBN ----");
        Scanner sc=new Scanner(System.in);
        System.out.println("document ISBN : ");
        String ISBN=sc.nextLine();
        return cntr.getDocumentByISBN(ISBN).toString();
    }
    public String getDocumentByTitle(){

        System.out.println("---- get document by title ----");
        Scanner sc=new Scanner(System.in);
        System.out.println("document title : ");
        String title=sc.nextLine();
        return cntr.getDocumentByTitle(title).toString();
    }
    public String getDocumentByEditor(){
        System.out.println("---- get document by Editeur ----");
        Scanner sc=new Scanner(System.in);
        System.out.println("document Editeur : ");
        String Editeur=sc.nextLine();
        return cntr.getDocumentByEditor(Editeur).toString();
    }
    public String getDocumentByAnneEdition(){
        System.out.println("---- get document by Anne d'Edition ----");
        Scanner sc=new Scanner(System.in);
        System.out.println("document Anne d'Edition : ");
        int AnneEdition=sc.nextInt();
        return cntr.getDocumentByAnneEdition(AnneEdition).toString();
    }
     public String getAllDocuments(){
        System.out.println("---- tout les Documents ----");
        ArrayList<Document> Document = (ArrayList<Document>)(cntr.getAllDocuments()).clone();
        String results="";
        for (Document doc : Document) {
            results += doc.toString() + "\n";
        }
        if(results==""){
            System.out.println("Aucun resultat");
        }
        return results;
    }
     public void menuKindle(Kindle k){
         long start = System.currentTimeMillis();
        long end = start + 2*1000;
        while (System.currentTimeMillis() < end) {
     switch (k.c.getTypeClient()) {
            case "Etudiant":
                {
                    System.out.println("Menu Etudiant : ");
                    System.out.println("1-list des documents ");
                    System.out.println("2-list des document par Année d'édition");
                    System.out.println("3-list des document par Titre");
                    System.out.println("4-list des document par editeur");
                    System.out.println("5-list des document par ISBN");
                    System.out.println("6-Deconnecter");
                    System.out.println("votre choix (1, 2, 3, 4, 5, 6) ? : ");
                    String choix =(new Scanner(System.in)).nextLine();
                    switch(choix){
                        case "1":
                            System.out.println(getAllDocuments());
                            menuKindle(k);
                        break;
                        case "2":
                            System.out.println(getDocumentByAnneEdition());
                            menuKindle(k);
                        break;
                        case "3":
                            System.out.println(getDocumentByTitle());
                            menuKindle(k);
                        break;
                        case "4":
                            System.out.println(getDocumentByEditor());
                            menuKindle(k);
                        break;
                        case "5":
                            System.out.println(getDocumentByISBN());
                            menuKindle(k);
                        break;
                        case "6":
                            System.out.println("au revoir !");
                            System.exit(0);
                        break;
                    }
                }
            case "Professeur":
                {
                    System.out.println("Menu Etudiant : ");
                    System.out.println("1-list des documents ");
                    System.out.println("2-list des document par Année d'édition");
                    System.out.println("3-list des document par Titre");
                    System.out.println("4-list des document par editeur");
                    System.out.println("5-list des document par ISBN");
                    System.out.println("6-Deconnecter");
                    System.out.println("votre choix (1, 2, 3, 4, 5, 6) ? : ");
                    String choix =(new Scanner(System.in)).nextLine();
                    switch(choix){
                        case "1":
                            System.out.println(getAllDocuments());
                            menuKindle(k);
                        break;
                        case "2":
                            System.out.println(getDocumentByAnneEdition());
                            menuKindle(k);
                        break;
                        case "3":
                            System.out.println(getDocumentByTitle());
                            menuKindle(k);
                        break;
                        case "4":
                            System.out.println(getDocumentByEditor());
                            menuKindle(k);
                        break;
                        case "5":
                            System.out.println(getDocumentByISBN());
                            menuKindle(k);
                        break;
                        case "6":
                            System.out.println("au revoir !");
                            System.exit(0);
                        break;
                    }
                }}
       }
     }
   public static void main(String[] args) throws IOException, ClassNotFoundException{
       
             Kindle k=new Kindle();
              k.Connexion();
              k.menuKindle(k);
        

   }
    
}
