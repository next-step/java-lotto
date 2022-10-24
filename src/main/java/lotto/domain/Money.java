package lotto.domain;

import static lotto.exception.ExceptionMessage.ERROR_NEGATIVE_VALUE;

public class Money {

    private static final int NEGATIVE_BOUND = 0;

    private final int value;

    public Money(final int value) {
        validateItemPrice(value);
        this.value = value;
    }

    public int countMaxNumberOfItemToBuy(final int itemPrice) {
        validateItemPrice(itemPrice);

        if (value == 0 || value < itemPrice) {
            return 0;
        }

        return value / itemPrice;
    }

    private void validateItemPrice(final int value) {
        if (value < NEGATIVE_BOUND) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_VALUE.getMessage());
        }
    }
}
