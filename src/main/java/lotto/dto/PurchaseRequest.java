package lotto.dto;

public class PurchaseRequest {

    private final long amount;

    public PurchaseRequest(final long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
