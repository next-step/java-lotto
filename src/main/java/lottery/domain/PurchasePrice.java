package lottery.domain;

public class PurchasePrice {

    private static final int MINIMUM_PRICE = 1;
    private final long purchasePrice;

    public PurchasePrice(long purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validatePurchasePrice(long purchasePrice) {
        if (purchasePrice < MINIMUM_PRICE)
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_PRICE_NOT_POSITIVE);
    }

    public long getPurchasePrice() {
        return purchasePrice;
    }
}
