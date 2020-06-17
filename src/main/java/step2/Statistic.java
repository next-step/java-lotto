package step2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class Statistic {

    private static final int DECIMAL_DIGIT = 2;

    public static int sum() {
        return Arrays.stream(Rank.values())
                .mapToInt(Rank::getProfit)
                .sum();
    }

    public static BigDecimal getYield(Money money) {
        int total = Rank.getTotal();
        BigDecimal bigDecimal = money.getYield(total)
                .setScale(DECIMAL_DIGIT, RoundingMode.HALF_EVEN);
        return bigDecimal;

    }

    public static void compare(List<Lotto> lottos, Lotto winLotto) {
        lottos.stream()
                .map(lotto -> lotto.compare(winLotto))
                .map(Rank::matches)
                .filter(rank -> !rank.isEmpty())
                .forEach(Rank::count);
    }
}
