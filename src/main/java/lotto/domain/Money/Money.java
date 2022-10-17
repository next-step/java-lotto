package lotto.domain.Money;

import java.util.Objects;

public class Money extends ImmutableMoney {

    public Money(final long money) {
        super(money);
    }

    public void add(final Money money) {
        this.money += money.money;
    }

    public void multiply(final int value) {
        this.money *= value;
    }

    public Double divideValue(final long value) {
        return (double) this.money / value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (getClass() != o.getClass() && o.getClass() != ImmutableMoney.class)) return false;
        ImmutableMoney money1 = (ImmutableMoney) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
