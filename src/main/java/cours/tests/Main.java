package cours.tests;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        //Salutation selon l'heure
        LocalTime heureActuelle = LocalTime.now();

        int heure = heureActuelle.getHour();

        if (heure >= 6 && heure < 12) {
            System.out.println("Bonjour");
        } else if (heure >= 12 && heure < 18){
            System.out.println("Bon après midi");
        } else if (heure >= 18 && heure < 22){
            System.out.println("Bonne soirée");
        } else {
            System.out.println("Bonne nuit");
        }
    }
}