package step2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Statistic {

    public static int sum() {
        return Arrays.stream(Rank.values())
                .mapToInt(Rank::getTotal)
                .sum();
    }


    public static BigDecimal getYield(Money money) {
        return new BigDecimal(money.getYield(sum()))
                .setScale(2, RoundingMode.HALF_EVEN);
    }
}
