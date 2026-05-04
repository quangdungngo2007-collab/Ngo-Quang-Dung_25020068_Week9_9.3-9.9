import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lop tien ich cung cap cac phep toan co ban nhu tim max va phep chia.
 */
public final class MathUtils {

    /** Logger dung de ghi lai nhat ky hoat dong cua he thong. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(MathUtils.class);

    /**
     * Ham khoi tao private de ngan viec khoi tao doi tuong tu lop tien ich.
     */
    private MathUtils() {
        // Khong cho phep khoi tao
    }

    /**
     * Tra ve so lon nhat trong hai so nguyen duoc cung cap.
     * @param a So nguyen thu nhat.
     * @param b So nguyen thu hai.
     * @return Gia tri lon nhat giua a va b.
     */
    public static int max(final int a, final int b) {
        LOGGER.info("Dang thuc hien so sanh: a={}, b={}", a, b);
        if (a >= b) {
            return a;
        }
        return b;
    }

    /**
     * Thuc hien phep chia hai so nguyen va kiem tra loi chia cho 0.
     * @param a So bi chia.
     * @param b So chia.
     * @return Ket qua cua phep chia a / b.
     * @throws IllegalArgumentException Neu b bang 0.
     */
    public static int divide(final int a, final int b) {
        if (b == 0) {
            LOGGER.error("Loi thuc thi: Khong the chia {} cho 0", a);
            throw new IllegalArgumentException("Divider must not be zero");
        }
        return a / b;
    }

    /**
     * Phuong thuc chinh de chay ung dung doc lap.
     * @param args Cac tham so dong lenh.
     */
    public static void main(final String[] args) {
        LOGGER.info("Ung dung MathUtils dang khoi dong...");
        max(10, 5);
    }
}