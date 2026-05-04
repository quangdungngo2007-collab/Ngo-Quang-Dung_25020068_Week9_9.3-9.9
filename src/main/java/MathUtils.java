// MathUtils.java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {
    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    public static int max(int a, int b) {
        logger.info("Executing max with parameters: a={}, b={}", a, b);
        return (a >= b) ? a : b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            logger.error("Division by zero error for value: {}", a);
            throw new IllegalArgumentException("Divider must not be zero");
        }
        return a / b;
    }
}