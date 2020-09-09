package AutoLotto.utils;

import java.math.BigDecimal;

public class CheckDivideBy {
    public static int divideToInt(String divided, String divider) {
        BigDecimal result = divideDown(divided, divider, 0);
        return result.intValue( );
    }

    public static double divideToDecimal(String divided, String divider) {
        BigDecimal result = divideDown(divided, divider, 2);
        return result.doubleValue();
    }

    private static BigDecimal divideDown(String divided, String divider, int i) {
        BigDecimal divided2 = new BigDecimal(divided);
        BigDecimal divider2 = new BigDecimal(divider);
        return divided2.divide(divider2, i, BigDecimal.ROUND_DOWN);
    }
}
