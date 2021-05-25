package lotto.model;

public class PurchaseCalculator {
    private static final int LOTTERY_PRICE = 1000;

    private final int purchaseAmount;

    public PurchaseCalculator(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int CalculatePurchasableCount() {
        return purchaseAmount / LOTTERY_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
