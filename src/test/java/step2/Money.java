package step2;

import java.util.Objects;

public class Money {
    public static Money of(int amount) {
        return new Money(amount);
    }

    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public boolean lessThan(Money money) {
        return amount < money.amount;
    }

    public int divide(Money money) {
        if (money.amount == 0) {
            throw new MoneyArithmeticException("/ by zero");
        }
        return amount / money.amount;
    }

    public Money multiply(int number) {
        return of(amount * number);
    }

    public Money subtract(Money money) {
        return of(amount - money.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" + "amount=" + amount + '}';
    }
}
