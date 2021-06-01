package Controller2;

import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
  
    public Document getDocumentByTitle(String titre){
        try {
            ArrayList<String> auteurList=new ArrayList<>();
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idDocument,ISBN,titre,url,anneeEdition,editeur from Document where titre =" + "'" + titre + "'");
            rs.next();
            int Docid=rs.getInt("idDocument");
            String ISBN=rs.getString("ISBN");
            String title=rs.getString("titre");
            String url=rs.getString("url");
            String editeur=rs.getString("editeur");
            int anneeEdition=rs.getInt("anneeEdition");
            Statement stmt2 =con.createStatement();
            String query = "select * from auteur where idDoc=" + "'" + Docid + "'";
            ResultSet rs2 = stmt2.executeQuery(query);
            while(rs2.next()){
                auteurList.add(rs2.getString("nom"));
            }
            Document Document=new Document(Docid,ISBN,title,auteurList,editeur,anneeEdition,url);
            return Document;
        } catch (SQLException ex) {
            return null;
        }
    }
    public Document getDocumentByIid(int id){
        try{
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque","root","");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from document where idDocument =" + "'" + id + "'");
        rs.next();
        int idDocument=rs.getInt("idDocument");
        String ISBN=rs.getString("ISBN");
        String titre=rs.getString("titre");
        String url=rs.getString("url");
        String editeur=rs.getString("editeur");
        int anneeEdition=rs.getInt("anneeEdition");
        ArrayList<String> auteurs = new ArrayList<>();
        Statement stmt2 = con.createStatement();
        ResultSet rs2 = stmt2.executeQuery("select nom from auteur where idDoc=" + "'" + id + "'");
        while(rs2.next()){
            auteurs.add(rs2.getString("nom"));
        }
             return new Document(idDocument,ISBN,titre,auteurs,editeur,anneeEdition,url);
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
        public ArrayList<Document> getAllDocuments(){
        ArrayList<Document> Document = new ArrayList<>();
        ArrayList<Integer> idDocuments =new ArrayList<>();
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque","root","");
            Statement stmt =con.createStatement();
            String query = "select * from document";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                idDocuments.add(rs.getInt("idDocument"));
            }
            for(Integer doc : idDocuments){
                Document.add(this.getDocumentByIid(doc));
            }
            return Document;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
   
    public Document getDocumentByISBN(String ISBN){
       try {
            ArrayList<String> auteurList=new ArrayList<>();
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idDocument,ISBN,titre,url,anneeEdition,editeur from Document where ISBN =" + "'" + ISBN + "'");
            rs.next();
            int Docid=rs.getInt("idDocument");
            String ISBn=rs.getString("ISBN");
            String title=rs.getString("titre");
            String url=rs.getString("url");
            String editeur=rs.getString("editeur");
            int anneeEdition=rs.getInt("anneeEdition");
            Statement stmt2 =con.createStatement();
            String query = "select * from auteur where idDoc=" + "'" + Docid + "'";
            ResultSet rs2 = stmt2.executeQuery(query);
            while(rs2.next()){
                auteurList.add(rs2.getString("nom"));
            }
            Document Document=new Document(Docid,ISBn,title,auteurList,editeur,anneeEdition,url);
            return Document;
        } catch (SQLException ex) {
            return null;
        }
    }
    public Document getDocumentByEditor(String Editeur){
        try {
            ArrayList<String> auteurList=new ArrayList<>();
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idDocument,ISBN,titre,url,anneeEdition,editeur from Document where editeur =" + "'" + Editeur + "'");
            rs.next();
            int Docid=rs.getInt("idDocument");
            String ISBn=rs.getString("ISBN");
            String title=rs.getString("titre");
            String url=rs.getString("url");
            String editeur=rs.getString("editeur");
            int anneeEdition=rs.getInt("anneeEdition");
            Statement stmt2 =con.createStatement();
            String query = "select * from auteur where idDoc=" + "'" + Docid + "'";
            ResultSet rs2 = stmt2.executeQuery(query);
            while(rs2.next()){
                auteurList.add(rs2.getString("nom"));
            }
            Document Document=new Document(Docid,ISBn,title,auteurList,editeur,anneeEdition,url);
            return Document;
        } catch (SQLException ex) {
            return null;
        }
    }
    public Document getDocumentByAnneEdition(int AnneEdition){
        try {
            ArrayList<String> auteurList=new ArrayList<>();
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select idDocument,ISBN,titre,url,anneeEdition,editeur from Document where anneeEdition =" + "'" + AnneEdition + "'");
            rs.next();
            int Docid=rs.getInt("idDocument");
            String ISBn=rs.getString("ISBN");
            String title=rs.getString("titre");
            String url=rs.getString("url");
            String editeur=rs.getString("editeur");
            int anneeEdition=rs.getInt("anneeEdition");
            Statement stmt2 =con.createStatement();
            String query = "select * from auteur where idDoc=" + "'" + Docid + "'";
            ResultSet rs2 = stmt2.executeQuery(query);
            while(rs2.next()){
                auteurList.add(rs2.getString("nom"));
            }
            Document Document=new Document(Docid,ISBn,title,auteurList,editeur,anneeEdition,url);
            return Document;
        } catch (SQLException ex) {
            return null;
        }
        }
    public Favoris[] getFavoris(int IdClient) {
            //...
            return null;
    }

    public Consultation[] getConsultation(int IdClient) {
            //...
            return null;
    }

    public String getDetailDocument(int IdDocument) {
            //...
            return null;
    }  
}
