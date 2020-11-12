package domain;

import java.util.Objects;

public class Money {
    private int value;

    public Money(int value) throws Exception {
        if(value < 0) {
            throw new Exception();
        }
        this.value = value;
    }

    public int dividedBy(Money price) throws Exception {
        if(price.isLessThanOrEqualsZero()) {
            throw new Exception();
        }

        return value / price.value;
    }

    private boolean isLessThanOrEqualsZero() {
        return this.value <= 0;
    }

    public boolean isGreaterThan(Money money){
        return this.value > money.value;
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
