package lotto.model;

import java.util.Objects;

import lotto.exception.InvalidMoneyException;

public class Money {

    private static final int LOTTO_AMOUNT = 1_000;
    private static final int DECIMAL_DENOMINATOR = 100;
    private static final double DECIMAL_NUMERATOR = 100.0;

    private final int value;

    public Money(int money) {
        validateMoneyOrThrow(money);
        value = money;
    }

    private void validateMoneyOrThrow(int money) {
        if (money < 0) {
            throw new InvalidMoneyException("money must be zero or positive");
        }
    }

    public int getLottoCount() {
        return value / LOTTO_AMOUNT;
    }

    public Double calculateRatio(Money money) {
        return Math.floor(money.value / (double) value * DECIMAL_DENOMINATOR) / DECIMAL_NUMERATOR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
