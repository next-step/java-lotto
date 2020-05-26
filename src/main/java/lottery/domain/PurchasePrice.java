package lottery.domain;

public class PurchasePrice {

    private final long purchasePrice;
    private static final int MINIMUM_PRICE = 1;

    public PurchasePrice(long purchasePrice) {
        this.purchasePrice = purchasePrice;
        validatePurchasePrice(purchasePrice);
    }

    private void validatePurchasePrice(long purchasePrice) {
        if (purchasePrice < MINIMUM_PRICE)
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_PRICE_NOT_POSITIVE);
    }

    public long getPurchasePrice() {
        return purchasePrice;
    }
}
