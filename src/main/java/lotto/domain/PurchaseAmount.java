package lotto.domain;

public class PurchaseAmount {
    private static final Long TICKET_PRICE = 1000L;

    private Long purchaseAmount;

    private PurchaseAmount(Long purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount of(Long purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private void validate(Long purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount == 0L) {
            throw new IllegalArgumentException("Must be greater than 0");
        }
    }

    public int getNumberOfTickets() {
        return (int) (purchaseAmount / TICKET_PRICE);
    }
}
