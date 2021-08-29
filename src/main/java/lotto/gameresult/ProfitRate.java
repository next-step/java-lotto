package lotto.gameresult;

import lotto.game.Payments;

public class ProfitRate {
    public static final int DECIMAL_POINTS_MAKER = 100;
    private final int prizeMoney;
    private final Payments payments;

    public ProfitRate(int prizeMoney, Payments payments) {
        this.prizeMoney = prizeMoney;
        this.payments = payments;
    }

    public double value() {
        return profitRateToTwoDecimalPoints();
    }

    private double profitRateToTwoDecimalPoints() {
        return Math.round(prizeMoney / (double) payments.value() * DECIMAL_POINTS_MAKER) / (double) DECIMAL_POINTS_MAKER;
    }
}
