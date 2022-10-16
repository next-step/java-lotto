package lotto;

import java.util.Objects;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public Money() {
        this.money = 0;
    }

    public Money add(Money other) {
        return new Money(money + other.money);
    }

    public Money multiplication(int count) {
        return new Money(money * count);
    }

    public int countBy(Money other) {
        return money / other.money;
    }

    public double calculateRate(Money other) {
        return (double) money / (double) other.money;
    }

    public int getMoney() {
        return money;
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
