import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mchsieh on 3/19/17.
 */
public class TestNGTest {
    @Test()
    public void evaluatesExpression() {
        Calculator calculator = new Calculator();
        int sum = calculator.evaluate("1+2+3");
        Assert.assertEquals(sum, 6);

    }
}
