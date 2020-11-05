package plateTests;

import app.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest extends Main {



    @BeforeEach
    void setUp() {
        System.out.print("before");
    }

    @AfterEach
    void tearDown() {
        System.out.print("after");
    }

    @Test
    void testMain() {

        System.out.print("testing");
    }
}