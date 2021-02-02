package lotto.util;

import java.math.BigDecimal;

public class NumberUtils {

    public static Integer returnInteger(String string) throws IllegalArgumentException {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static Double calculateYield(int inputPrice, int income) {
        BigDecimal bd = new BigDecimal((double) income / inputPrice);
        return bd
            .setScale(2, BigDecimal.ROUND_FLOOR)
            .doubleValue();
    }


    public static int convertNullToNumber(Integer value) {
        if (value == null) {
            return 0;
        }
        return value;
    }
}
