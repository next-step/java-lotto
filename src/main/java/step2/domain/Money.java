package step2.domain;

import java.util.Objects;

public class Money {
    private int money;

    public Money(final int money) {
        this.money = money;
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

    public int toInt() {
        return this.money;
    }

    public void subtraction(int value) {
        this.money -= value;
    }
}
