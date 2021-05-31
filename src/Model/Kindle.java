package Model;


public class Kindle {
    private  String Mac;
    private  String Modele;
    private int id;
    private boolean Emprunte=false;
    public Kindle(String Mac, String Modele) {
        this.Mac = Mac;
        this.Modele = Modele;
    }

    public Kindle(int Id,String mac,String modele,boolean Emprunte) {
        this.Mac= mac;
        this.Modele=modele;
        this.id=Id;
        this.Emprunte=Emprunte;
    }
    
    public String getMac() {
        return Mac;
    }

    public String getModele() {
        return Modele;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEmprunte() {
        return Emprunte;
    }

    public void setEmprunte(boolean emprunte) {
            Emprunte = emprunte;
    }

    @Override
    public String toString() {
        String empr;
        if(Emprunte==true){
           return "Kindle [ " + "id = " + id + ", Modele = " + Modele + ", Mac = " + Mac + ", Emprunte =  Emprunter";
        }else{
            return "Kindle [ " + "id = " + id + ", Modele = " + Modele + ", Mac = " + Mac + ", Emprunte = Non Emprunter";
        }
        
    }
    
    
}
