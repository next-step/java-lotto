package AutoLotto.utils;

import java.math.BigDecimal;

public class CheckDivideBy {
    public static int divideForInt(String left, String right) {
        BigDecimal divided = new BigDecimal(left);
        BigDecimal divider = new BigDecimal(right);
        BigDecimal result = divided.divide(divider, BigDecimal.ROUND_DOWN);
        return result.intValue( );
    }
}
