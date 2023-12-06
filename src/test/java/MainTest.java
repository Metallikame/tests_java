import cours.tests.Main;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testGreetMessage() {
        // Rediriger la sortie console pour capturer le message imprimé
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Tester la méthode greetMessage pour différents moments de la journée
        // Matin
        simulateTimeAndTestGreetMessage("Bonjour\n");
        // Après-midi
        simulateTimeAndTestGreetMessage("Tu as bien mangé ce midi ?\n");
        // Soirée
        simulateTimeAndTestGreetMessage("Ton après midi s'est bien passé ?\n");
        // Nuit
        simulateTimeAndTestGreetMessage("Va dormir\n");
    }

    private void simulateTimeAndTestGreetMessage(String expectedOutput) {
        // Rediriger la sortie console pour capturer le message imprimé
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Simuler l'heure actuelle pour les tests et capturer la sortie
        Main.greetMessage();

        // Obtenir la sortie imprimée dans la console
        String printedOutput = outputStreamCaptor.toString().replaceAll("\r", "");

        // Vérifier si la sortie imprimée correspond à celle attendue
        assertEquals(expectedOutput, printedOutput);
    }
}
