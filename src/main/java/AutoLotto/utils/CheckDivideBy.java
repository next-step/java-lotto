package AutoLotto.utils;

import java.math.BigDecimal;

public class CheckDivideBy {
    public static int divideToInt(String left, String right) {
        BigDecimal result = divideDown(left, right, 0);
        return result.intValue( );
    }

    public static double divideToDecimal(String left, String right) {
        BigDecimal result = divideDown(left, right, 2);
        return result.doubleValue();
    }

    private static BigDecimal divideDown(String left, String right, int i) {
        BigDecimal divided = new BigDecimal(left);
        BigDecimal divider = new BigDecimal(right);
        return divided.divide(divider, i, BigDecimal.ROUND_DOWN);
    }
}
