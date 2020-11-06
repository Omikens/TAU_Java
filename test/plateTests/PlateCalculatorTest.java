package plateTests;

import app.PlateCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

class PlateCalculatorTest extends PlateCalculator {
    private PlateCalculator plateCalculator;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUp() {
        plateCalculator = new PlateCalculator();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void tearDown() {
        plateCalculator = null;
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void plateCalculator() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(("20" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "2" + System.lineSeparator()  // simulating user input
                + "2" + System.lineSeparator()  // barbell weight and plates available
                + "2" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "2" + System.lineSeparator()
        ).getBytes());
        System.setIn(in);

        int result = plateCalculator.PlateCalculator(120);
        assertEquals(1, result);
    }

    @Test
    void plateCalculator2() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(("20" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "0" + System.lineSeparator()
                + "0" + System.lineSeparator()  // simulating user input
                + "0" + System.lineSeparator()  // barbell weight and plates available
                + "0" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "2" + System.lineSeparator()
        ).getBytes());
        System.setIn(in);
        PlateCalculator(120);
        assertNotEquals("What weight would you like to use: What is the weight of barbell: " +
                        "What plates do you have? Enter a number: 45kg: 35kg: 25kg: 20kg: 10kg: " +
                        "5kg: 2,5kg: You cannot achieve desired weight with this plate setup!" +
                        "This is the closest you can get:Put this on each side of bar: 45: 035: 025: 020: 010: 05: 02.5: 2"
              , outContent.toString());
    }

    @Test
    void plateCalculator3() {
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream(("10" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "2" + System.lineSeparator()  // simulating user input
                + "2" + System.lineSeparator()  // barbell weight and plates available
                + "2" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "2" + System.lineSeparator()
        ).getBytes());
        System.setIn(in);
        PlateCalculator(120);
        assertNotNull(outContent.toString());
    }
}