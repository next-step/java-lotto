package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int PRICE = 1000;
    private final int money;

    public Money(int money) {
        validation(money);
        this.money = money;
    }

    private void validation(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("음수 값이 들어올 수 없습니다.");
        }
    }

    public int value() {
        return this.money;
    }

    public int getBuyableCount() {
        return this.money / PRICE;
    }

    public double getYield(Money total) {
        return total.value() / (double) this.money;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(money);
    }

    @Override
    public String toString() {
        return "Money{" +
                "money=" + money +
                '}';
    }
}
