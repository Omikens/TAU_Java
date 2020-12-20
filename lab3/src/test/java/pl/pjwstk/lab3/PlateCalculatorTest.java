package pl.pjwstk.lab3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class PlateCalculatorTest {
    private PlateCalculator plateCalculator;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUp() {
        plateCalculator = new PlateCalculator();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void tearDown() {
        plateCalculator = null;
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void plateCalculator() {
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

        int result = plateCalculator.calculate(120);
        assertEquals(1, result);
    }

    @Test
    public void plateCalculator2() {
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
        plateCalculator.calculate(120);
        assertNotEquals("What weight would you like to use: What is the weight of barbell: " +
                        "What plates do you have? Enter a number: 45kg: 35kg: 25kg: 20kg: 10kg: " +
                        "5kg: 2,5kg: You cannot achieve desired weight with this plate setup!" +
                        "This is the closest you can get:Put this on each side of bar: 45: 035: 025: 020: 010: 05: 02.5: 2"
              , outContent.toString());
    }

    @Test
    public void plateCalculator3() {
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
        plateCalculator.calculate(120);
        assertNotNull(outContent.toString());
    }

    @Test
    public void testNeedWeight() {
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

        PlateCalculator.targetWeight = 120;
        plateCalculator.calculate(120);
        double result = plateCalculator.needWeight();
        assertEquals(100, result, 2);
    }

    @Test
    public void testNeed45() {
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

        PlateCalculator.targetWeight = 110;
        plateCalculator.calculate(110);
        int result = plateCalculator.need45();
        assertEquals(2, result);
    }

    @Test
    public void testNeed35() {
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

        PlateCalculator.targetWeight = 90;
        plateCalculator.calculate(90);
        int result = plateCalculator.need35();
        assertEquals(2, result);
    }

    @Test
    public void testNeed25() {
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

        PlateCalculator.targetWeight = 110;
        plateCalculator.calculate(110);
        int result = plateCalculator.need25();
        assertEquals(4, result);
    }

    @Test
    public void testNeed20() {
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

        PlateCalculator.targetWeight = 220;
        plateCalculator.calculate(220);
        int result = plateCalculator.need20();
        assertEquals(10, result);
    }

    @Test
    public void testNeed10() {
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

        PlateCalculator.targetWeight = 100;
        plateCalculator.calculate(100);
        int result = plateCalculator.need10();
        assertEquals(8, result);
    }

    @Test
    public void testNeed5() {
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

        PlateCalculator.targetWeight = 150;
        plateCalculator.calculate(150);
        int result = plateCalculator.need5();
        assertEquals(26, result);
    }

    @Test
    public void testNeed2half() {
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

        PlateCalculator.targetWeight = 90;
        plateCalculator.calculate(90);
        double result = plateCalculator.need2half();
        assertNotEquals(0, result);
    }
}