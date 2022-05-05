package lotto.domain;

public class EarningRate {
    private static final double CRITERION = 1;

    private final double earningRate;

    public EarningRate(double earningRate) {
        this.earningRate = earningRate;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public boolean isProfit() {
        return earningRate > CRITERION;
    }
}
