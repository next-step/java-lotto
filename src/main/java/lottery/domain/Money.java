package lottery.domain;

import java.util.Objects;

public class Money {

    public static final Money ZERO = new Money(0);

    public final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money valueOf(int amount) {
        return amount == 0 ? ZERO : new Money(amount);
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
        return Money.valueOf(this.amount + addend);
    }

    public Money times(int multiplier) {
        return Money.valueOf(this.amount * multiplier);
    }

    public Money divide(int divisor) {
        return Money.valueOf(this.amount / divisor);
    }
}
