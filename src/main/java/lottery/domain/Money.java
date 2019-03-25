package lottery.domain;

import java.util.Objects;

public class Money {

    public final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public Money add(int addend) {
        return new Money(this.amount + addend);
    }

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier);
    }

    public Money divide(int dividend) {
        return new Money(this.amount / dividend);
    }
}
