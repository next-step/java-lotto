package camp.nextstep.edu.lotto.domain.vo;

import java.util.Objects;

public class Money {
    private static final Money ZERO = Money.from(0);
    private static final int MINIMUM_VALUE = 0;

    private final int value;

    private Money(int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("'intValue' must be greater than or equal to " + MINIMUM_VALUE);
        }
        this.value = value;
    }

    public static Money from(int value) {
        return new Money(value);
    }

    public static Money zero() {
        return ZERO;
    }

    public Money divideBy(Money money) {
        if (ZERO.equals(money)) {
            throw new IllegalArgumentException("'money' must not be zero");
        }
        return new Money(this.value / money.value);
    }

    public int intValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
