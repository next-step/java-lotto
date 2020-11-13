package domain;

import java.util.Objects;

public class Money {
    private Long value;

    public static Money of(Long value) throws Exception {
        return new Money(value);
    }

    private Money(Long value) throws Exception {
        if(value < 0) {
            throw new Exception();
        }

        this.value = value;
    }

    public Money plus(Money money) throws Exception {
        return Money.of(value + money.value);
    }

    public Money multiply(Long number) throws Exception{
        return new Money(value * number);
    }

    public Double dividedBy(Money money) throws Exception {
        if(money.isLessThanOrEqualsZero()) {
            throw new Exception();
        }

        return Double.valueOf(value) / Double.valueOf(money.value);
    }

    private boolean isLessThanOrEqualsZero() {
        return this.value <= 0L;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
