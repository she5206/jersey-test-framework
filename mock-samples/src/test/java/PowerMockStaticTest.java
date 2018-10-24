import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

/**
 * Created by mchsieh on 3/22/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassWithStatics.class)
public class PowerMockStaticTest {
    @Test
    public void test() {
        PowerMockito.mockStatic(ClassWithStatics.class);
        PowerMockito.when(ClassWithStatics.getString()).thenReturn("Hello!");
        assertEquals(ClassWithStatics.getString(), "Hello!");
    }

    @Test
    public void testPrivate() throws Exception {
        ClassWithStatics classUnderTest = PowerMockito.spy(new ClassWithStatics());
        PowerMockito.doReturn(20).when(classUnderTest, "getInt");
        assertEquals(classUnderTest.getPrivate(), 20);
    }
}
