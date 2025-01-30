package entites;

public class Chambre  {
    private int numero ;
    private String type ;

    public Chambre(int numero, String type) {
        this.numero = numero;
        this.type = type;
    }
    public int getNumero() {
        return numero;
    }
    public String getType() {
        return type;
    }
    public String toString(){
        System.out.println("---------------");
        return "Numéro de chambre : "+numero + "\nType : " + type ;

    }
}
