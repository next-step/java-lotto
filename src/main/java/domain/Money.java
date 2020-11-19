package domain;

import java.util.Objects;

public class Money {
    private long value;

    public static Money of(long value) throws Exception {
        if(value < 0) {
            throw new Exception();
        }

        return new Money(value);
    }

    private Money(long value){
        this.value = value;
    }

    public Money multiply(long number){
        return new Money(value * number);
    }

    public Double dividedBy(Money money) throws Exception {
        if(money.isLessThanOrEqualsZero()) {
            throw new Exception();
        }

        return (double) value / (double) money.value;
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
