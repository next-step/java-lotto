package step3.utils;

public class NumberUtils {

    public static long getSafeNumber(Long number) {
        if (number == null) {
            return 0;
        }

        return number;
    }
}
