package entites;

import java.util.ArrayList;
import java.util.Objects;

public class Hotel {
    private String nom ;
    private String adresse ;
    private String ville ;
    private ArrayList<Chambre> listeChambre = new ArrayList<>();
    private ArrayList<Reservation> listeReservation = new ArrayList<Reservation>();

    public Hotel(String nom, String adresse, String ville) {
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
    }
    public void ajouterChambre(Chambre chambre) {
        listeChambre.add(chambre);
    }
    public void verifierChambresDisponibles(Chambre chambre) {
        if (listeChambre.contains(chambre)) {
            listeChambre.remove(chambre);
        }
    }
    public void afficherChambresDisponibles() {
        System.out.println("------Chambres dispos----------");
        for (Chambre chambre : listeChambre) {
            verifierChambresDisponibles(chambre) ;
            System.out.println(chambre.toString());
            }
        }

    public void reserverChambre(Client client , Chambre chambre , String dateDebut , String dateFin) {
        listeReservation.add(new Reservation(client,chambre,dateDebut,dateFin));
    }
    public void afficherReservations() {
        for(Reservation reservation : listeReservation) {
            System.out.println(reservation.toString());
        }
    }

}
