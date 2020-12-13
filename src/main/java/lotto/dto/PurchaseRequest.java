package lotto.dto;

import java.util.List;

public class PurchaseRequest {

    private final long amount;

    private final List<String> manualNumbers;

    public PurchaseRequest(final long amount, final List<String> manualNumbers) {
        this.amount = amount;
        this.manualNumbers = manualNumbers;
    }

    public long getAmount() {
        return amount;
    }

    public List<String> getManualNumbers() {
        return manualNumbers;
    }
}
