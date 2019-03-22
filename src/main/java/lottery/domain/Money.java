package lottery.domain;

import java.util.Objects;

public class Money {
    private final int amount;

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

    public int divide(int dividend) {
        return this.amount / dividend;
    }
}
