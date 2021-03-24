package lotto.domain;

import lotto.utils.StringUtils;

public class Amount {
    public final static int DIVISION_UNIT = 1000;
    public final static int MIN_PURCHASE_AMOUNT = 0;

    private final int value;
    private int manualQuantity = 0;

    public Amount(String amountValue, String manualValue) {
        this(StringUtils.toInteger(amountValue), StringUtils.toInteger(manualValue));
    }

    public Amount(final int value, final int manualQuantity) {
        validation(value);
        this.value = value;
        this.manualQuantity = manualQuantity;
    }

    public void validation(final int value) {
        if (value <= MIN_PURCHASE_AMOUNT)
            throw new IllegalArgumentException("금액은 0원 이상이어야 합니다.");
        if ((value % DIVISION_UNIT) > MIN_PURCHASE_AMOUNT)
            throw new IllegalArgumentException("금액은 1000원 단위여야 합니다.");
    }

    public int quantity() {
        return (value / DIVISION_UNIT) - manualQuantity;
    }

    public int value() {
        return value;
    }

    public int manualQuantity() {
        return manualQuantity;
    }
}
