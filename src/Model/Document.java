
package Model;

import java.util.ArrayList;
import java.util.Arrays;

public  class Document {
        private int id;
	private  String ISBN;
	private  String titre,editeur;
        private String url;
	private ArrayList<String> auteurs = new ArrayList<>();
	private int anneeEdition;
	/***********************CONSTRUCTORS********************************/
	public Document(String ISBN,String titre, ArrayList<String> auteurs,
                String editeur,int anneEd,String url)
        {
                this.id=id;
		this.ISBN=ISBN;
		this.titre=titre;
		this.auteurs=auteurs;
		this.editeur=editeur;
		this.anneeEdition=anneEd;
		this.url=url;
        }
        public Document(int id,String ISBN,String titre, ArrayList<String> auteurs,
                String editeur,int anneEd,String url)
        {
                this.id=id;
		this.ISBN=ISBN;
		this.titre=titre;
		this.auteurs=auteurs;
		this.editeur=editeur;
		this.anneeEdition=anneEd;
		this.url=url;
        }
//	public Document(Document d) {
//		this.ISBN=d.getISBN();
//		this.titre=new String(d.getTitre());
//		this.auteurs=d.getAuteurs().clone();//Clone()
//		this.editeur=new String(d.getEditeur());
//		this.anneeEdition=d.getAnneeEdition();
//		this.url=new String(d.getUrl());
//	}
        
        /******************************************************************/
	
                
        
        /***********************SETTERS AND GETTERS*************************/
	public String getISBN() {
		return this.ISBN;
	}
        public int getId(){
            return this.id;
        }
	
	public String getTitre() {
		return this.titre;
	}
	
	public String getEditeur() {
		return this.editeur;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public int getAnneeEdition() {
		return this.anneeEdition;
	}
	
	public ArrayList<String> getAuteurs() {
		return this.auteurs;
	}

	
	public void setUrl(String url) {
		this.url=url;
	}

        public void setAuteurs(ArrayList<String> auteurs) {
            this.auteurs = auteurs;
        }

    @Override
    public String toString() {
        return "Document [ " + "id = " + id + ", ISBN = " + ISBN + ", titre = " + titre + ", editeur = " + editeur + ", url = " + url + ", auteurs = " + auteurs + ", anneeEdition = " + anneeEdition + ']';
    }
	
	
        /******************************************************************/
	
   
        
}
