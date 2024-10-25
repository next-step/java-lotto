package lotto.domain;

public class PurchaseInfo {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private final int numberOfManualPurchase;

    public PurchaseInfo(int purchaseAmount, int manualPurchase) {
        this.purchaseAmount = purchaseAmount;
        this.numberOfManualPurchase = manualPurchase;
    }

    public int getNumberOfManualPurchase() {
        return numberOfManualPurchase;
    }

    public int getNumberOfAutoPurchase() {
        return purchaseAmount - numberOfManualPurchase;
    }

    public int getPruchaseAmount() {
        return 1000 * purchaseAmount;
    }

}
