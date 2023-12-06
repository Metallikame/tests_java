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
        LocalTime now = LocalTime.now();
        Main.greetMessage(timeMorning);
        if (now.isAfter(timeMorning.minusMinutes(1)) && now.isBefore(timeMorning.plusMinutes(1))) {
            assertEquals("Bonjour\n", outContent.toString());
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

        // Test pour l'heure du soir (entre 18h et 22h)
        LocalTime timeEvening = LocalTime.of(20, 0); // Modifier l'heure selon le test
        LocalTime now = LocalTime.now();
        Main.farewellMessage(timeEvening);
        if (now.isAfter(timeEvening.minusMinutes(1)) && now.isBefore(timeEvening.plusMinutes(1))) {
            assertEquals("Bonne soirée\n", outContent.toString());
        }

        System.setOut(System.out);
    }
}
