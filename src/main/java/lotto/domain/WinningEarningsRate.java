package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WinningEarningsRate {
    private double earningsRate;

    public WinningEarningsRate(int money, double totalWinningMoney) {
        earningsRate = calculationEarningsRate(money, totalWinningMoney);
    }

    private double calculationEarningsRate(int money, double totalWinningMoney) {
        return Math.round(totalWinningMoney / money * 100) / 100.0;
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}
