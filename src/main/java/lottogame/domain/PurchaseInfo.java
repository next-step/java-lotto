package lottogame.domain;

public class PurchaseInfo {

    private PurchaseAmount purchaseAmount;
    private PurchaseCount purchaseCount;

    public PurchaseInfo(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        purchaseCount = new PurchaseCount(purchaseAmount.getLottoCount());
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public PurchaseCount getPurchaseCount() {
        return purchaseCount;
    }
}