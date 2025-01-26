package entites;

public class Client {
    private String nom ;
    private String email ;

    public Client(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }
    public String getNom(){
        return this.nom ;
    }
    public String getEmail(){
        return this.email ;
    }
    public String toString(){
        return "Nom : "+nom + "\nEmail : " + email;
    }
}
