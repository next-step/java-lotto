package lotto.domain.winning;

public class EarningRate {
    private Long totalWinningAmount;
    private Long usedPurchaseAmount;
    private Double earningRate;

    EarningRate(long totalWinningAmount, long usedPurchaseAmount) {
        this.totalWinningAmount = totalWinningAmount;
        this.usedPurchaseAmount = usedPurchaseAmount;
        this.earningRate = (double) totalWinningAmount / usedPurchaseAmount;
    }

    public static EarningRate of(long totalWinningAmount, long usedPurchaseAmount) {
        return new EarningRate(totalWinningAmount, usedPurchaseAmount);
    }

    public double get() {
        return earningRate;
    }
}
