package lotto.domain;

public class Money {
    private static final int ZERO = 0;

    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public int divide(Money money) {
        if (money.isZero()) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return this.value / money.value;
    }

    private boolean isZero() {
        return value == ZERO;
    }

    public boolean greaterThan(Money other) {
        return value >= other.value;
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
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
