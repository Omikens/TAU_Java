package plateTests;

import app.PlateCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

class PlateCalculatorTest extends PlateCalculator {
    private PlateCalculator plateCalculator;


    @BeforeEach
    void setUp() {
        plateCalculator = new PlateCalculator();
    }

    @AfterEach
    void tearDown() {
        plateCalculator = null;
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
}