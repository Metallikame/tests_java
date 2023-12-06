import cours.tests.Main;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void greetMessageTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test pour l'heure du matin (entre 6h et 12h)
        LocalTime timeMorning = LocalTime.of(9, 0); // Modifier l'heure selon le test
        LocalTime nowMorning = LocalTime.now();
        Main.greetMessage(timeMorning);
        if (nowMorning.isAfter(timeMorning.minusMinutes(1)) && nowMorning.isBefore(timeMorning.plusMinutes(1))) {
            assertEquals("Bonjour\n", outContent.toString());
        }

        outContent.reset();

        // Test pour l'heure de l'après-midi (entre 12h et 18h)
        LocalTime timeAfternoon = LocalTime.of(15, 0); // Modifier l'heure selon le test
        LocalTime nowAfternoon = LocalTime.now();
        Main.greetMessage(timeAfternoon);
        if (nowAfternoon.isAfter(timeAfternoon.minusMinutes(1)) && nowAfternoon.isBefore(timeAfternoon.plusMinutes(1))) {
            assertEquals("Tu as bien mangé ce midi ?\n", outContent.toString());
        }

        outContent.reset();

        // Test pour l'heure du soir (entre 18h et 22h)
        LocalTime timeEvening = LocalTime.of(20, 0); // Modifier l'heure selon le test
        LocalTime nowEvening = LocalTime.now();
        Main.greetMessage(timeEvening);
        if (nowEvening.isAfter(timeEvening.minusMinutes(1)) && nowEvening.isBefore(timeEvening.plusMinutes(1))) {
            assertEquals("Ton après midi s'est bien passé ?\n", outContent.toString());
        }

        outContent.reset();

        // Test pour l'heure de nuit (après 22h ou avant 6h)
        LocalTime timeNight = LocalTime.of(23, 0); // Modifier l'heure selon le test
        LocalTime nowNight = LocalTime.now();
        Main.greetMessage(timeNight);
        if (nowNight.isAfter(timeNight.minusMinutes(1)) || nowNight.isBefore(LocalTime.of(6, 0))) {
            assertEquals("Va dormir\n", outContent.toString());
        }

        System.setOut(System.out);
    }

    @Test
    void reverseString_PalindromeInput_ReturnsBienDit() {
        String input = "radar\n"; // Entrée qui est un palindrome
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.reverseString();

        String expectedOutput = "Bien dit !";
        String actualOutput = outContent.toString().trim();
        assertEquals(expectedOutput, actualOutput);

        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void reverseString_NonPalindromeInput_ReturnsReversedString() {
        String input = "hello"; // Entrée qui n'est pas un palindrome
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.reverseString();

        String reversedInput = new StringBuilder(input.trim()).reverse().toString();
        String expectedOutput = "Voici votre mot à l'envers : " + reversedInput;
        String actualOutput = outContent.toString().trim();
        assertEquals(expectedOutput, actualOutput);

        System.setIn(System.in);
        System.setOut(System.out);
    }


    @Test
    void farewellMessageTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test pour l'heure du matin (entre 6h et 12h)
        LocalTime timeMorning = LocalTime.of(9, 0); // Modifier l'heure selon le test
        LocalTime nowMorning = LocalTime.now();
        Main.farewellMessage(timeMorning);
        if (nowMorning.isAfter(timeMorning.minusMinutes(1)) && nowMorning.isBefore(timeMorning.plusMinutes(1))) {
            assertEquals("Profite bien de ta matinée !\n", outContent.toString());
        }

        outContent.reset();

        // Test pour l'heure de l'après-midi (entre 12h et 18h)
        LocalTime timeAfternoon = LocalTime.of(15, 0); // Modifier l'heure selon le test
        LocalTime nowAfternoon = LocalTime.now();
        Main.farewellMessage(timeAfternoon);
        if (nowAfternoon.isAfter(timeAfternoon.minusMinutes(1)) && nowAfternoon.isBefore(timeAfternoon.plusMinutes(1))) {
            assertEquals("Bon après midi\n", outContent.toString());
        }

        outContent.reset();

        // Test pour l'heure du soir (entre 18h et 22h)
        LocalTime timeEvening = LocalTime.of(20, 0); // Modifier l'heure selon le test
        LocalTime nowEvening = LocalTime.now();
        Main.farewellMessage(timeEvening);
        if (nowEvening.isAfter(timeEvening.minusMinutes(1)) && nowEvening.isBefore(timeEvening.plusMinutes(1))) {
            assertEquals("Bonne soirée\n", outContent.toString());
        }

        outContent.reset();

        // Test pour l'heure de nuit (après 22h ou avant 6h)
        LocalTime timeNight = LocalTime.of(23, 0); // Modifier l'heure selon le test
        LocalTime nowNight = LocalTime.now();
        Main.farewellMessage(timeNight);
        if (nowNight.isAfter(timeNight.minusMinutes(1)) || nowNight.isBefore(LocalTime.of(6, 0))) {
            assertEquals("Va dormir\n", outContent.toString());
        }

        System.setOut(System.out);
    }
}
