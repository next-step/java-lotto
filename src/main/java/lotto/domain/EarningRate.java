package lotto.domain;

public class EarningRate {
    private static final double CRITERION = 1;

    private final double value;

    public EarningRate(double value) {
        this.value = value;
    }

    public static EarningRate of(Amount prizeAmount, Amount purchaseAmount) {
        return new EarningRate((double) prizeAmount.getValue() / (double) purchaseAmount.getValue());
    }

    public double getValue() {
        return value;
    }

    public boolean isProfit() {
        return value > CRITERION;
    }
}
