

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

import org.mockito.Matchers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

public class MockitoTest {

    @Test
    public void testSimpleInt() {
        // give
        TestService test = mock(TestService.class);
        // when
        when(test.getUniqueId()).thenReturn(43);
        // then
        assertEquals(test.getUniqueId(), 43);
    }

    // Demonstrates the return of multiple values
    @Test
    public void testMoreThanOneReturnValue() {
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("is neat!!");
        String result = i.next() + " " + i.next();
        assertEquals("Mockito is neat!!", result);
    }

    @Test
    public void testReturnValueDependentOnMethodParameter() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        assertEquals(1, c.compareTo("Mockito"));
    }

    @Test
    public void testReturnValueInDependentOnMethodParameter() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        assertEquals(-1, c.compareTo(9));
    }

    @Test(expected = IOException.class)
    public void OutputStreamWriter_rethrows_an_exception_from_OutputStream()
            throws IOException {
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        doThrow(new IOException()).when(mock).close();
        osw.close();
    }

    @Test
    public void testVerify() {
        // give
        TestService test = mock(TestService.class);
        when(test.getUniqueId()).thenReturn(43);

        test.testing(12);
        test.getUniqueId();
        test.getUniqueId();
        test.someMethod("Hello World");
        test.someMethod("called at least once");
        test.someMethod("called at least twice");
        test.someMethod("called five times");
        test.someMethod("called at most 3 times");

        // now check if method testing was called with the parameter 12
        verify(test).testing(Matchers.eq(12));

        // was the method called twice?
        verify(test, times(2)).getUniqueId();

        // other alternatives for verifying the number of method calls for a method
        verify(test, never()).someMethod("never called");
        verify(test, atLeastOnce()).someMethod("called at least once");
        verify(test, atMost(3)).someMethod("called at most 3 times");

        //	Will all fail because we didn't met the conditions.
        verify(test, atLeast(2)).someMethod("called at least twice");
        verify(test, times(5)).someMethod("called five times");
    }

    @Test
    public void testCalcService() {
        CalculatorService test = mock(CalculatorService.class);
        when(test.add(20.0, 10.0)).thenReturn(30.0);
        MathApplication mathApplication = new MathApplication();
        mathApplication.setCalculatorService(test);
        double exp = mathApplication.add(20.0, 10.0);
        assertEquals(exp, 30.0, 0.0);
    }
}
