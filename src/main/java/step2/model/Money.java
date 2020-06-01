package step2.model;

import java.text.MessageFormat;
import java.util.Objects;

public class Money {

    private static final Money ZERO = Money.valueOf(0);
    private static final int MIN_VALUE = 0;
    private final int value;

    private Money(int value) {
        if (isLessThenMinValue(value)) {
            throw new IllegalArgumentException("0원 이상 입력 할 수 있습니다.");
        }

        this.value = value;
    }

    private boolean isLessThenMinValue(int value) {
        return value < MIN_VALUE;
    }

    public static Money valueOf(int value) {
        return new Money(value);
    }

    public static Money zero() {
        return ZERO;
    }

    public Money plus(Money money) {
        return Money.valueOf(this.value + money.getValue());
    }

    public Money minus(Money money) {
        return Money.valueOf(this.value - money.getValue());
    }

    public boolean greaterThan(Money money) {
        return money.getValue() <= this.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}원", value);
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
