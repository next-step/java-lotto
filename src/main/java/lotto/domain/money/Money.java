package lotto.domain.money;

import java.util.Objects;

public class Money {

    protected final long money;
    protected static final int MONEY_MINIMUM = 0;

    protected static final String MONEY_NEGATIVE_EXCEPTION = "Money에는 " + MONEY_MINIMUM + "이상의 값만 들어올 수 있습니다.";

    public Money() {
        this(0);
    }

    public Money(long money) {
        if (money < MONEY_MINIMUM) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_EXCEPTION);
        }
        this.money = money;
    }

    public long money() {
        return money;
    }

    public Money add(final long money) {
        return new Money(this.money + money);
    }

    public Money multiply(final int value) {
        return new Money(this.money * value);
    }

    public Double divideValue(final long value) {
        return (double) this.money / value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
