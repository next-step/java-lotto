package lottogame.domain;

public class PurchaseInfo {

    private PurchaseAmount purchaseAmount;
    private PurchaseCount purchaseCount;

    public PurchaseInfo(PurchaseAmount purchaseAmount, PurchaseCount purchaseCount) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseCount = purchaseCount;
    }

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public PurchaseCount getPurchaseCount() {
        return purchaseCount;
    }

    public long getAutomaticCount() {
        return purchaseCount.getAutomaticCount();
    }
}