package lotto.domain;

public class Amount {
    public final static int DIVISION_UNIT = 1000;
    public final static int MIN_PURCHASE_AMOUNT = 0;
    private int value;

    public Amount(int value) {
        validation(value);
        this.value = value;
    }

    public void validation(int value) {
        if (value <= MIN_PURCHASE_AMOUNT)
            throw new IllegalArgumentException("금액은 0원 이상이어야 합니다.");
        if ((value % DIVISION_UNIT) > MIN_PURCHASE_AMOUNT )
            throw new IllegalArgumentException("금액은 1000원 단위여야 합니다.");
    }

    public int quantity() {
        return value / DIVISION_UNIT;
    }

    public int value() {
        return value;
    }
}
