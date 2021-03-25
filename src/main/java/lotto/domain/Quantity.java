package lotto.domain;

public class Quantity {
    private static final String MINUS_QUANTITY_ERROR = "0개 이상 입력해주세요";
    private final int quantity;

    public Quantity(int quantity) {
        isMinusQuantityValid(quantity);
        this.quantity = quantity;
    }

    private void isMinusQuantityValid(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(MINUS_QUANTITY_ERROR);
        }
    }

    public boolean isUnderQuantity(int quantity) {
        return this.quantity >= quantity;
    }

    public int uiQuantity() {
        return quantity;
    }
}
