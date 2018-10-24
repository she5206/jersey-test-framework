/**
 * Created by mchsieh on 3/18/17.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CalculatorService.class)  //注意：非 XxxUtil.class
public class PowerMockTest {

    private CalculatorService mockUserService;
    private MathApplication mathApplication;

    @Test
    public void testCalcService() {
        mockUserService = PowerMockito.mock(CalculatorService.class);
        PowerMockito.when(mockUserService.add(20.0, 10.0)).thenReturn(30.0);
        mathApplication = new MathApplication();
        mathApplication.setCalculatorService(mockUserService);
        assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0.0);
    }
}