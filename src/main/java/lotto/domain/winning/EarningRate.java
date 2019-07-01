package lotto.domain.winning;

public class EarningRate {
    private Double earningRate;

    private EarningRate(long totalWinningAmount, long usedPurchaseAmount) {
        validate(totalWinningAmount);
        validate(usedPurchaseAmount);
        this.earningRate = (double) totalWinningAmount / usedPurchaseAmount;
    }

    private void validate(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must grather than 0");
        }
    }

    public static EarningRate of(long totalWinningAmount, long usedPurchaseAmount) {
        return new EarningRate(totalWinningAmount, usedPurchaseAmount);
    }

    public double get() {
        return earningRate;
    }
}
