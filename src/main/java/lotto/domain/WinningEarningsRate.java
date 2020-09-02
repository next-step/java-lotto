package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WinningEarningsRate {
    private final static Integer DIVIDE_SCALE = 2;
    private final static RoundingMode DIVIDE_ROUND_MODE = RoundingMode.DOWN;

    private double earningsRate;

    public WinningEarningsRate(int money, double totalWinningMoney) {
        earningsRate = calculationEarningsRate(money, totalWinningMoney);
    }

    private double calculationEarningsRate(int money, double totalWinningMoney) {
        return BigDecimal.valueOf(totalWinningMoney)
                .divide(BigDecimal.valueOf(money), DIVIDE_SCALE, DIVIDE_ROUND_MODE)
                .doubleValue();
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}
