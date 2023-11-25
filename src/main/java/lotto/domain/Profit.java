package lotto.domain;

public class Profit {
    private final double profit;

    private Profit(double profit) {
        this.profit = profit;
    }

    public static Profit of(PurchaseAmount purchaseAmount, PrizeSummary prizeSummary) {
        long prizeAmount = prizeSummary.calculatePrizeAmount();
        return new Profit(calculateProfit(purchaseAmount, prizeAmount));
    }

    private static double calculateProfit(PurchaseAmount purchaseAmount, long prizeAmount) {
        return purchaseAmount.divideByPurchaseAmount(prizeAmount);
    }

    public double getProfit() {
        return profit;
    }
}
