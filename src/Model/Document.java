
package Model;

import java.util.Arrays;


public abstract class Document {
	
        private int id;
	private final String ISBN;
	private final String titre,editeur;
        private String url;
	private String[] auteurs= new String[5];
	private final int anneeEdition;
	static private int numId=0;
        
	/***********************CONSTRUCTORS********************************/
	public Document(String ISBN,String titre, String[] auteurs,
                String editeur,int anneEd,String url)
        {
                this.id=numId++;
		this.ISBN=ISBN;
		this.titre=titre;
		this.auteurs=auteurs;
		this.editeur=editeur;
		this.anneeEdition=anneEd;
		this.url=url;
        }
	
	public Document(Document d) {
		this.ISBN=d.getISBN();
		this.titre=new String(d.getTitre());
		this.auteurs=d.getAuteurs().clone();//Clone()
		this.editeur=new String(d.getEditeur());
		this.anneeEdition=d.getAnneeEdition();
		this.url=new String(d.getUrl());
	}
        
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
	
	public String[] getAuteurs() {
		return this.auteurs;
	}

	
	public void setUrl(String url) {
		this.url=url;
	}
	
	public void setAuteurs(String[] auteurs) {
		this.auteurs=auteurs.clone();
	}
        /******************************************************************/
	
        @Override
        public String toString(){
            return "[Numero= "+
                    id+",ISBN= "+
                    ISBN+", Titre= "+
                    titre+", Auteurs="+
                    Arrays.toString(auteurs)+", Editeur="+
                    editeur+",Annee d'edition="+anneeEdition+"]";
        }
	
        
}
