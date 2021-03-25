package lotto.domain;

public class PrePurchaseInformation {
    private final Amount amount;
    private final String[] values;

    public PrePurchaseInformation(Amount amount, String values) {
        this.amount = amount;
        this.values = values.split("\n");
        validation();
    }

    public void validation() {
        if (amount.manualQuantity() != values.length) {
            throw new IllegalArgumentException("수동 구매 번호를 수동 구매 입력 장수에 맞게 입력해 주세요.");
        }
    }

    public String[] values() {
        return values;
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
