package lottery.domain;

public class PurchasePrice {

    private static final int LOTTERY_TICKET_PRICE = 1000;
    private final long purchasePrice;

    private PurchasePrice(long purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public static PurchasePrice from(long purchasePrice) {
        return new PurchasePrice(purchasePrice);
    }

    private void validatePurchasePrice(long purchasePrice) {
        if (purchasePrice < LOTTERY_TICKET_PRICE)
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_PRICE_NOT_ENOUGH);
    }

    public long getPurchasePrice() {
        return purchasePrice;
    }
}
