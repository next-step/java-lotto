package lotto.model;

public class purchaseCalculator {
    private static final int LOTTERY_PRICE = 1000;

    private final int purchaseAmount;

    public purchaseCalculator(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int calculatePurchasableCount() {
        return purchaseAmount / LOTTERY_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
