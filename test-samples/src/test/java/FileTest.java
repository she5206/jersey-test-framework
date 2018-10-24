import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.testng.Assert;

import java.io.IOException;

/**
 * Created by mchsieh on 3/19/17.
 */
public class FileTest {
    @Test
    public void testHi() throws IOException {
        String data = IOUtils.toString(
                this.getClass().getResourceAsStream("data.json"),
                "UTF-8"
        );
        Assert.assertEquals(data, "hi");
    }
}
