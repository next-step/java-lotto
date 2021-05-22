package study.lotto;

import java.math.BigDecimal;

public class WinningPrize {
    private static final BigDecimal forthPrize = BigDecimal.valueOf(5000);
    private static final BigDecimal thirdPrize = BigDecimal.valueOf(50000);
    private static final BigDecimal secondPrize = BigDecimal.valueOf(1500000);
    private static final BigDecimal firstPrize = BigDecimal.valueOf(2000000000);

    public static BigDecimal prize(int matchCount) {
        if (matchCount==3) return forthPrize;
        if (matchCount==4) return thirdPrize;
        if (matchCount==5) return secondPrize;
        if (matchCount==6) return firstPrize;
        return BigDecimal.ZERO;
    }
}
