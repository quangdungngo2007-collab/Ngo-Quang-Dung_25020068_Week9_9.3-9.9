// MathUtilsTest.java
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    void testMax() {
        assertEquals(10, MathUtils.max(10, 5));
    }

    @Test
    void testPathCompatibility() {
        // Tranh hardcode "logs\\app.log"
        String path = Paths.get("logs", "app.log").toString();
        assertNotNull(path);
    }
}