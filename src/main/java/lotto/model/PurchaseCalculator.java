package lotto.model;

public class PurchaseCalculator {
    private static final int LOTTERY_PRICE = 1000;

    private final int purchaseAmount;

    public PurchaseCalculator(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchasableLottoCounts() {
        return this.purchaseAmount / LOTTERY_PRICE;
    }
}