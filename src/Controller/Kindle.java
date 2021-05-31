package Controller;

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

public class Kindle {
    static boolean repeat=true;
    Client c=null;
    Kindle k;
    String hote = "127.0.0.1" ;
    int port = 1000 ;
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
            System.out.println("entre votr login :");
            String login= (new Scanner(System.in)).nextLine();
            sortie.write(login+"\n");
            System.out.println("entre votr passwd : ");
            String passwd= (new Scanner(System.in)).nextLine();
            sortie.write(passwd+"\n");
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
                System.out.println("bienvenue " + c.getNom() +" "+ c.getPrenom()+"\n ");
            
                System.out.println(kindle+"]");
                return true;
    }
    //GETTERS DE DOCUMENT
    public Document getDocumentByISBN(String ISBN) throws IOException{
        try(Socket soc=new Socket(hote,port)){
            
        }
        return null;
    }
    public ArrayList<Document> getDocumentByTitle(String titre){
        
        return null;
    }
    public ArrayList<Document> getDocumentByEditor(String Editeur){
        
        return null;
    }
    public ArrayList<Document> getDocumentByAnneEdition(int AnneEdition){
        
        return null;
    }
    public ArrayList<Document> getAllDocuments(){
        
        return null;
    }
   public static void main(String[] args) throws IOException, ClassNotFoundException{
      Kindle k=new Kindle();
      k.Connexion();
        switch (k.c.getTypeClient()) {
            case "Etudiant":
                {
                    System.out.println("Menu Etudiant : ");
                    System.out.println("1-list des documents ");
                    System.out.println("2-list des document disponible");
                    System.out.println("3-list des document emprunter par vous ");
                    System.out.println("5-Deconnecta");
                    String choix =(new Scanner(System.in)).nextLine();
                    break;
                }
            case "Professeur":
                {
                    System.out.println("Menu Professeur : ");
                    System.out.println("1-list des documents ");
                    System.out.println("2-list des document disponible");
                    System.out.println("3-list des document emprunter par vous ");
                    System.out.println("4-Deconnecté");
                    String choix =(new Scanner(System.in)).nextLine();
                }
        }
   }
    
}
