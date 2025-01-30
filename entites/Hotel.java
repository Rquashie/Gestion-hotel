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
        if (!verifierChambreReserve(chambre)) {
            listeReservation.add(new Reservation(client, chambre, dateDebut, dateFin));
        }
    }



    public void afficherReservations() {
        for(Object reservation : listeReservation) {
            System.out.println(reservation.toString());
        }
    }
    public boolean verifierChambreReserve(Chambre ch) {
        for (int i = 0 ; i < listeReservation.size() ; i++) {
            if (Integer.parseInt(listeReservation.get(i).getChambre()) == ch.getNumero()) {
                return false;
            }
        }
        return true ;
    }

    public void changerAffectation(Client client , Chambre chambre1 , Object chambre2) {
       for(int i = 0 ; i < listeReservation.size() ; i++) {
            if(listeReservation.get(i).equals(chambre1)){
               Reservation chambre2Res = (Reservation) chambre2 ;
                listeReservation.set(i,chambre2Res) ;
            }
            }
           }

       }




