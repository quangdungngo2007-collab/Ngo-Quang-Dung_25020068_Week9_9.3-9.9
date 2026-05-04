import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    // Khởi tạo đối tượng Logger tĩnh cho lớp này
    private static final Logger logger = LoggerFactory.getLogger(MathUtilsTest.class);

    @Test
    void testMax() {
        // EP
        assertEquals(10, MathUtils.max(10, 5)); // a > b
        assertEquals(7, MathUtils.max(7, 7)); // a = b
        assertEquals(8, MathUtils.max(3, 8)); // a < b

        // BVA
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 0));
        assertEquals(0, MathUtils.max(Integer.MIN_VALUE, 0));
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, MathUtils.max(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    void testDivide() {
        assertEquals(5, MathUtils.divide(10, 2));   // b > 0
        assertEquals(-5, MathUtils.divide(10, -2)); // b < 0
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.divide(10, 0); // assertThrows(exception.class, executable)
        });
    }

//    @Test
//    void testFilePathHardcoded() {
//        // Định nghĩa đường dẫn cứng bằng dấu của Windows
//        String expectedPath = "logs\\app.log";
//
//        // Tạo file thực tế bằng API
//        java.io.File file = new java.io.File("logs", "app.log");
//
//        assertEquals(expectedPath, file.getPath());
//    }

    // Refactor:
    void testFilePathHardcoded() {
        // Sử dụng Paths.get() để Java tự động chọn dấu phân cách (/ hoặc \) theo hệ điều hành
        Path expectedPath = Paths.get("logs", "app.log");

        // Tạo file thực tế bằng API
        java.io.File file = new java.io.File("logs", "app.log");

        assertEquals(expectedPath.toString(), file.getPath());
    }

    @BeforeAll
    static void beforeAll() {
        logger.info("=== Bat dau chay MathUtilsTest ===");
    }

    @AfterAll
    static void afterAll() {
        logger.info("=== Ket thuc ===");
    }
}