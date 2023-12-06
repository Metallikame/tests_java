package cours.tests;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Salutation selon l'heure
        LocalTime heureActuelle = LocalTime.now();

        int heure = heureActuelle.getHour();

        if (heure >= 6 && heure < 12) {
            System.out.println("Bonjour");
        } else if (heure >= 12 && heure < 18){
            System.out.println("Tu as bien mangé ce midi ?");
        } else if (heure >= 18 && heure < 22){
            System.out.println("Ton après midi s'est bien passé ?");
        } else {
            System.out.println("Va dormir");
        }
        
        //print en miroir
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un mot :");
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String reversedStr = String.valueOf(sb.reverse());
        //palindrôme
        if (str.equalsIgnoreCase(reversedStr)) {
            System.out.println("Bien dit !");
        } else {
            System.out.println("Voici votre mot à l'envers : " + reversedStr);
        }

        //Au revoir selon l'heure
        LocalTime heureActuellement = LocalTime.now();
        int heure2 = heureActuelle.getHour();

        if (heure2 >= 6 && heure2 < 12) {
            System.out.println("Profite bien de ta matinée !");
        } else if (heure2 >= 12 && heure2 < 18) {
            System.out.println("Bon après midi");
        } else if (heure2 >= 18 && heure2 < 22) {
            System.out.println("Bonne soirée");
        } else {
            System.out.println("Va dormir");
        }
    }
}