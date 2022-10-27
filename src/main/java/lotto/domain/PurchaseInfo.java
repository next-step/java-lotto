package lotto.domain;

public class PurchaseInfo {

    private static final Integer LOTTO_PRICE = 1000;

    private final PurchasePrice purchasePrice;
    private final Integer autoAmount;
    private final Integer manualAmount;

    public PurchaseInfo(Integer purchasePrice, Integer manualAmount) {
        this.purchasePrice = new PurchasePrice(purchasePrice);
        this.autoAmount = this.purchasePrice.getAmount() - manualAmount;
        this.manualAmount = manualAmount;
    }

    public Integer getPurchasePrice() {
        return purchasePrice.getPurchasePrice();
    }

    public Integer getAutoAmount() {
        return autoAmount;
    }

    public Integer getManualAmount() {
        return manualAmount;
    }
}
