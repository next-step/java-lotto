package lotto.domain;

import static lotto.exception.ExceptionMessage.ERROR_NEGATIVE_VALUE;
import static lotto.exception.ExceptionMessage.ERROR_OVER_TAKE_MONEY;

import java.util.Objects;

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

    public Money take(final int amount) {
        validateAmount(amount);

        if (amount == 0) {
            return this;
        }

        return new Money(this.value - amount);
    }

    private void validateAmount(final int value) {
        if (value < NEGATIVE_BOUND) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_VALUE.getMessage());
        }

        if (this.value < value) {
            throw new IllegalArgumentException(ERROR_OVER_TAKE_MONEY.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Money)) {
            return false;
        }

        return this.value == ((Money) o).value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
