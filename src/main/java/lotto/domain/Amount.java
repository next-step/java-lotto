package lotto.domain;

import java.util.Objects;

public class Amount {
    public static final String NEGATIVE_AMOUNT = "금액은 음수일 수 없습니다.";
    public static final Amount ZERO = new Amount(0);
    public static final Amount LOTTO_AMOUNT = new Amount(1000);

    private double value;

    public Amount(final double amount) {
        validationCheck(amount);

        this.value = amount;
    }

    public static Amount of(final int amount) {
        return new Amount(amount);
    }

    public static Amount lotto() {
        return LOTTO_AMOUNT;
    }

    private void validationCheck(final double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT);
        }
    }

    public boolean isSmallThan(final Amount amount) {
        return this.value < amount.get();
    }

    public double get() {
        return value;
    }

    public Amount divide(final Amount amount) {
        return new Amount(this.value / amount.value);
    }

    public Amount multiply(final Amount amount) {
        return new Amount(value * amount.value);
    }

    public Amount plus(final Amount amount) {
        return new Amount(value + amount.value);
    }

    public Amount minus(final Amount amount) {
        return new Amount(value - amount.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
