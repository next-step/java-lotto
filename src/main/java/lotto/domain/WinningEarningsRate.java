package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WinningEarningsRate {
    private final static Integer DIVIDE_SCALE = 2;
    private final static RoundingMode DIVIDE_ROUND_MODE = RoundingMode.DOWN;

    private final int money;

    public WinningEarningsRate(int money) {
        this.money = money;
    }

    public double calculationEarningsRate(Integer totalWinningMoney) {
        return BigDecimal.valueOf(totalWinningMoney)
                .divide(BigDecimal.valueOf(money), DIVIDE_SCALE, DIVIDE_ROUND_MODE)
                .doubleValue();
    }
}
