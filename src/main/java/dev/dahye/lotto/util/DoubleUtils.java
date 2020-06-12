package dev.dahye.lotto.util;

import java.math.BigDecimal;

public final class DoubleUtils {
    private DoubleUtils() {
    }

    public static double parseDoubleSecondDigit(double number) {
        BigDecimal bigDecimal = new BigDecimal(number);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
