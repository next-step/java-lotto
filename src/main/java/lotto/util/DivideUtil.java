package lotto.util;

import java.math.BigDecimal;

public class DivideUtil {

    public static final int DIVIDE_SCALE_SIZE = 2;

    private DivideUtil() {
    }

    public static double divide(long numerator, int denominator) {
        return BigDecimal.valueOf(numerator).divide(
                BigDecimal.valueOf(denominator),
                DIVIDE_SCALE_SIZE,
                BigDecimal.ROUND_HALF_EVEN
        ).doubleValue();
    }

}
