package lotto.domain;

public class Profit {
    private final double profit;

    public Profit(double profit) {
        this.profit = profit;
    }

    public static Profit of(PurchaseAmount purchaseAmount, PrizeSummary prizeSummary) {
        return new Profit(calculateProfit(purchaseAmount, prizeSummary.getPrizeAmount()));
    }

    private static double calculateProfit(PurchaseAmount purchaseAmount, int prizeAmount) {
        return purchaseAmount.devideWith(prizeAmount);
    }

    public double getProfit() {
        return profit;
    }
}
