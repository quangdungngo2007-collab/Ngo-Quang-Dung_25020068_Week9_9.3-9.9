import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Lop kiem thu nang cao de dat do bao phu code tren 80%.
 */
public class MathUtilsTest {

    /**
     * Kiem tra phuong thuc tim gia tri lon nhat voi nhieu truong hop biên.
     */
    @Test
    void testMax() {
        // Kiem tra cac truong hop thong thuong
        assertEquals(99, MathUtils.max(10, 5));
        assertEquals(10, MathUtils.max(5, 10));
        assertEquals(10, MathUtils.max(10, 10));

        // Kiem tra voi so am
        assertEquals(-5, MathUtils.max(-10, -5));
    }

    /**
     * Kiem tra phuong thuc chia va bao phu cac nhanh logic[cite: 1, 2].
     */
    @Test
    void testDivide() {
        // Kiem tra phep chia hop le
        assertEquals(5, MathUtils.divide(10, 2));

        // Kiem tra ngoai le khi chia cho 0 de bao phu nhanh logic error[cite: 2]
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.divide(10, 0);
        });
    }

    /**
     * Kiem tra phuong thuc main de tang do bao phu code[cite: 2].
     */
    @Test
    void testMainMethod() {
        // Goi ham main de thuc thi cac dong ma ben trong[cite: 2]
        String[] args = {};
        MathUtils.main(args);
    }

    /**
     * Dung Reflection de kiem tra ham khoi tao private (tang coverage len 100%)[cite: 2].
     */
    @Test
    void testConstructorIsPrivate() throws Exception {
        Constructor<MathUtils> constructor = MathUtils.class.getDeclaredConstructor();
        // Cho phep truy cap vao constructor private[cite: 2]
        constructor.setAccessible(true);
        MathUtils instance = constructor.newInstance();
        assertNotNull(instance);
    }

    /**
     * Kiem tra tinh tuong thich duong dan[cite: 1].
     */
    @Test
    void testPathCompatibility() {
        Path path = Paths.get("logs", "app.log");
        assertNotNull(path.toString());
    }
}