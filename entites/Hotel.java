package entites;

import java.util.ArrayList;
import java.util.Objects;

public class Hotel {
    private String nom ;
    private String adresse ;
    private String pays ;
    private ArrayList<Chambre> listeChambre = new ArrayList<Chambre>();
    private ArrayList<Reservation> listeReservation = new ArrayList<Reservation>();

    public Hotel(String nom, String adresse, String pays) {
        this.nom = nom;
        this.adresse = adresse;
        this.pays = pays;
    }
    public void ajouterChambre(Chambre chambre) {
        listeChambre.add(chambre);
    }

    public boolean verifierChambre(Integer numChambre) {
       for (Reservation reservation : listeReservation) {
               if (Integer.parseInt(reservation.getChambre()) == numChambre) {
                   return false;
               }
           }
        return true;
    }

    public void afficherChambresDisponibles() {
        System.out.println("------Chambres dispos----------");
        ;
        for (Chambre chambre : listeChambre) {
            if (verifierChambre(chambre.getNumero())) {
                System.out.println(chambre.toString());
            }
        }
    }

    public void reserverChambre(Client client , Chambre chambre , String dateDebut , String dateFin) {
        if (verifierChambre(chambre.getNumero())) {
            listeReservation.add(new Reservation(client, chambre, dateDebut, dateFin));
            System.out.println("Réservation effectué");
        } else {
            System.out.println("Le chambre déja réservée");
        }
    }

    public void afficherReservations() {
        for(Object reservation : listeReservation) {
            System.out.println(reservation.toString());
        }
    }
    public boolean verifierChambreReserve(Chambre ch) {
        for (Reservation reservation : listeReservation) {
            if(Integer.parseInt(reservation.getChambre()) == ch.getNumero()){
                return false;
            }
        }
        return true ;
    }

    public void changerAffectation(Client client , Chambre chambre1 , Chambre chambre2) {
      for(int i = 0 ; i < listeReservation.size() ; i++) {
          Reservation res = listeReservation.get(i);
          if(Integer.parseInt(res.getChambre()) == chambre1.getNumero()){
              res.setChambre(chambre2.getNumero());
          }
            }
           }
    public void supressionReservation(Client client , Chambre chambre) {
       boolean trouve = false ;
       for (int i = 0; i < listeReservation.size(); i++) {
           Reservation res = listeReservation.get(i);
           if (client.getNom().equals(res.getClient()) && chambre.getNumero()== Integer.parseInt(res.getChambre())) {
               listeReservation.remove(i);
               System.out.println("Réservation supprimé");
               trouve = true ;
               break;
           }
           }

           if(!trouve) {
               System.out.println("La réservation n'existe pas");
           }
       }

    }






