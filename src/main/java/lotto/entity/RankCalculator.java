package lotto.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class RankCalculator {

    private RankCalculator() {

    }

    public static BigDecimal sum(List<WinningResult> analyzer) {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (WinningResult winningResult : analyzer) {
            sum = winningResult.add(sum);
        }
        return sum;
    }

    public static BigDecimal calculateRate(int inputMoney, BigDecimal winnerMoney) {
        return winnerMoney.divide(BigDecimal.valueOf(inputMoney), 2, RoundingMode.HALF_UP);
    }

}
