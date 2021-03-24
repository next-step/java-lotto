package lotto.domain;

public class PrePurchaseInformation {
    private final Amount amount;
    private final String values;

    public PrePurchaseInformation(Amount amount, String values) {
        this.amount = amount;
        this.values = values;
    }

    public String[] values() {
        return values.split("\n");
    }

    public int autoQuantity() {
        return amount.quantity();
    }

    public int manualQuantity() {
        return amount.manualQuantity();
    }

    public Amount amount() {
        return amount;
    }
}
