package plateTests;

import app.PlateCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
        
    }
}