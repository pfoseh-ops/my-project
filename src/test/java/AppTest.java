import com.example.App;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testApp() {
        App myApp = new App();

        String result = myApp.getStatus();

        assertTrue(result.contains("<h1>Paul Foseh</h1>"));
        assertTrue(result.contains("<p>Senior DevOps, Cloud, SRE &amp; DevSecOps Engineer"));
        assertTrue(result.indexOf("<h1>") < result.indexOf("<p>"));
    }

}
