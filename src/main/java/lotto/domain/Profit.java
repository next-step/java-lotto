package lotto.domain;

public class Profit {
    private final double profit;

    private Profit(double profit) {
        this.profit = profit;
    }

    public static Profit of(PurchaseAmount purchaseAmount, PrizeSummary prizeSummary) {
        return new Profit(calculateProfit(purchaseAmount, prizeSummary.calculatePrizeAmount()));
    }

    private static double calculateProfit(PurchaseAmount purchaseAmount, long prizeAmount) {
        return purchaseAmount.divideByPurchaseAmount(prizeAmount);
    }

    public double getProfit() {
        return profit;
    }
}
