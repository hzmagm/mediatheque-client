package Model;


public class Livre {
    private final int nbPage;
    private final String type;
    private final String tome;
    
    
    /***********************CONSTRUCTOR******************************/
    public Livre(String ISBN,String titre, String[] auteurs,
            String editeur,int anneEd,String url,int nbPage,String type,String tome)
    {
        this.nbPage=nbPage;
        this.type=new String(type);
        this.tome=new String(tome);
    }
    /******************************************************************/
    
    
    /***********************GETTERS*************************/
     public int getNbPage() {
        return nbPage;
    }

    public String getType() {
        return type;
    }

    public String getTome() {
        return tome;
    }
    
    /******************************************************************/
    
    
    @Override
    public String toString(){
        return "C'est un livre : "+super.toString()+
                "et Nombre de pages="+this.nbPage+
                ", Type: "+this.type+
                ", Tome: "+this.tome;
    }
}
