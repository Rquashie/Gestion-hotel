package entites;

import java.util.ArrayList;
import java.util.Objects;

public class Hotel {
    private String nom ;
    private String adresse ;
    private String ville ;
    private ArrayList<Chambre> listeChambre = new ArrayList<>();
    private ArrayList<Object> listeReservation = new ArrayList<Object>();

    public Hotel(String nom, String adresse, String ville) {
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
    }
    public void ajouterChambre(Chambre chambre) {
        listeChambre.add(chambre);
    }
    public boolean chambreEstDisponible(Integer numChambre) {
        for (Object reservation : listeReservation) {
            if (reservation instanceof Reservation) {
                Reservation res = (Reservation) reservation;
                if (Integer.parseInt(res.getChambre()) == numChambre) {
                    return false;
                }
            }
        }
        return true;
    }

    public void afficherChambresDisponibles() {
        System.out.println("------Chambres dispos----------");;
        for (Chambre chambre : listeChambre) {
           if(chambreEstDisponible(chambre.getNumero())){
               System.out.println(chambre.toString()) ;
            }

            }
        }

    public void reserverChambre(Client client , Chambre chambre , String dateDebut , String dateFin) {
        listeReservation.add(new Reservation(client,chambre,dateDebut,dateFin));
    }
    public void afficherReservations() {
        for(Object reservation : listeReservation) {
            System.out.println(reservation.toString());
        }
    }
    public void changerAffectation(Client client , Chambre chambre1 , Chambre chambre2) {
       for(int i = 0 ; i < listeReservation.size() ; i++) {
           if(listeReservation.get(i) instanceof Chambre) {
               Chambre ch = (Chambre) listeReservation.get(i);
               if(ch.equals(chambre1) ){
                   listeReservation.set(i,chambre2);
               }
           }

       }
    }

}
