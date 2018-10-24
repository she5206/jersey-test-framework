import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;

import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class EasyMockTest {

    private MathApplication mathApplication;

    private CalculatorService calcService;

    @Before
    public void setUp() {
        mathApplication = new MathApplication();
        calcService = EasyMock.niceMock(CalculatorService.class);
        mathApplication.setCalculatorService(calcService);
    }

    @Test
    public void testCalcService() {

        //add the behavior to add numbers
        EasyMock.expect(calcService.add(20.0, 10.0)).andReturn(40.0);
        EasyMock.expect(calcService.subtract(20.0, 10.0)).andReturn(0.0);
        EasyMock.expect(calcService.divide(20.0, 10.0)).andReturn(0.0);
        EasyMock.expect(calcService.multiply(20.0, 10.0)).andReturn(0.0);

        //activate the mock
        EasyMock.replay(calcService);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(20.0, 10.0), 40.0, 0);

        //test the subtract functionality
        Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 0.0, 0);

        //test the multiply functionality
        Assert.assertEquals(mathApplication.divide(20.0, 10.0), 0.0, 0);

        //test the divide functionality
        Assert.assertEquals(mathApplication.multiply(20.0, 10.0), 0.0, 0);

        //verify call to calcService is made or not
        EasyMock.verify(calcService);
    }
}