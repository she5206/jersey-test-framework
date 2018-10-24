import org.testng.annotations.Test;

/**
 * Created by mchsieh on 3/19/17.
 */
public class ProfileTest {

    @Test
    public void testProfile(){
        String hostname = System.getProperty("hostname");
        System.out.println(hostname);
    }
}
