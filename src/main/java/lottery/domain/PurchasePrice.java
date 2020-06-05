package lottery.domain;

public class PurchasePrice {

    private static final int LOTTERY_TICKET_PRICE = 1000;
    private static final int ZERO_TICKET_COUNTS = 0;
    private final long purchasePrice;
    private final int manualTicketCounts;

    private PurchasePrice(long purchasePrice, int manualTicketCounts) {
        validatePurchasePrice(purchasePrice, manualTicketCounts);
        this.purchasePrice = purchasePrice;
        this.manualTicketCounts = manualTicketCounts;
    }

    public static PurchasePrice of(long purchasePrice, int manualTicketCounts) {
        return new PurchasePrice(purchasePrice, manualTicketCounts);
    }

    public int getAutomaticTicketCounts() {
        return (int) (purchasePrice - (manualTicketCounts * LOTTERY_TICKET_PRICE)) / LOTTERY_TICKET_PRICE;
    }

    private void validatePurchasePrice(long purchasePrice, int manualTicketCounts) {
        if (manualTicketCounts < ZERO_TICKET_COUNTS) {
            throw new IllegalArgumentException(ErrorMessages.TICKET_COUNTS_NEGATIVE);
        }
        if (manualTicketCounts == ZERO_TICKET_COUNTS && purchasePrice < LOTTERY_TICKET_PRICE) {
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_PRICE_NOT_ENOUGH);
        }
        if (purchasePrice < LOTTERY_TICKET_PRICE * manualTicketCounts) {
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_PRICE_NOT_ENOUGH);
        }
    }

    public long getPurchasePrice() {
        return purchasePrice;
    }

    public int getManualTicketCounts() {
        return manualTicketCounts;
    }
}
