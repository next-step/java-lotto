package lotto.money;

import java.util.Objects;

public class Money {
    public static final int ZERO_VALUE = 0;
    public static final Money ZERO = Money.init(ZERO_VALUE);

    private final int money;

    public Money(int money) {
        validate(money);

        this.money = money;
    }

    private void validate(int money) {
        if (money < ZERO_VALUE) {
            throw new IllegalArgumentException("Money value should be equal or greater than " + ZERO_VALUE);
        }
    }

    public static Money init(int payment) {
        return new Money(payment);
    }

    public int getAffordableCount(Money price) {
        return this.money / price.money;
    }

    public int toInt() {
        return money;
    }

    public Money addition(Money anotherMoney) {
        return Money.init(money + anotherMoney.money);
    }

    public Money multiply(int operand) {
        return Money.init(money * operand);
    }

    public double earningRate(Money payment) {
        return (double) this.money / payment.money;
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
}
