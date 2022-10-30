package lotto.domain;

public class PurchaseMoney {

    private static final int MINIMUM_PURCHASE_MONEY = 1000;
    private static final String MINIMUM_PURCHASE_MONEY_MESSAGE = "구입금액은 최소 1000원 이상이어야 합니다.";

    private final int value;

    public PurchaseMoney(int value) {
        validateMinimum(value);
        this.value = value;
    }

    private void validateMinimum(int value) {
        if (value < MINIMUM_PURCHASE_MONEY) {
            throw new IllegalArgumentException(MINIMUM_PURCHASE_MONEY_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
