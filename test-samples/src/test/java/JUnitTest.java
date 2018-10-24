/**
 * Created by mchsieh on 3/12/17.
 */

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

public class JUnitTest {

    @Test
    public void evaluatesExpression() {
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("1+2+3");
        assertEquals(6, sum);
    }

    @Test
    public void evaluatesExpression2() {
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("1+2+4");
        assertEquals(7, sum);
    }

    @Test
    public void evaluatesExpression3() {
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("1+2+5");
        assertEquals(8, sum);
    }

    // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runBeforeTestClass() {
        System.out.println("@BeforeClass - runBeforeTestClass");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runAfterTestClass() {
        System.out.println("@AfterClass - runAfterTestClass");
    }

    // Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() {
        System.out.println("@Before - runBeforeTestMethod");
    }

    @After
    public void runAfterTestMethod() {
        System.out.println("@After - runAfterTestMethod");
        // sleep 1 second
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

