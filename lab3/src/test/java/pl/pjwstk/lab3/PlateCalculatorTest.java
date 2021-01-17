package pl.pjwstk.lab3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class PlateCalculatorTest {
    private PlateCalculator plateCalculator;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @InjectMocks
    PlateCalculatorApplication plateCalculatorApplication = new PlateCalculatorApplication();

    @Mock
    PlateCalculator plateService;

    @Test
    public void testPlateCalculatorMock1() {
        when(plateService.calculate(120)).thenReturn(2);

        Assert.assertEquals(plateCalculatorApplication.platecalculator(120), 2);
    }
/*
    @Test
    public void testPlateCalculatorMock2() {
        given(plateService.calculate(120)).willReturn(2);

        Assert.assertEquals(plateCalculatorApplication.platecalculator(120), 2);
    }

    @Test
    public void testPlateCalculatorMock3() {
        when(plateService.needWeight()).thenReturn((double) 2);

        Assert.assertNotNull(outContent.toString());
    }
*/

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