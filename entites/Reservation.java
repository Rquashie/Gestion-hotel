package entites;

public class Reservation {
    private String client;
    private int chambre;
    private String dateDebut;
    private String dateFin;

    public Reservation(Client client, Chambre chambre, String dateDebut, String dateFin) {
        this.client = client.getNom();
        this.chambre = chambre.getNumero();
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String toString() {
        System.out.println("--------Reservation----------");
        return "Client : " + client + "\nChambre : " + chambre + "\nDateDebut : " + dateDebut + "\nDateFin : " + dateFin+"\n";

    }
}
