package lotto.domain;

import java.util.Objects;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public Money useMoney(int useMoney) {
        return new Money(money - useMoney);
    }

    public int calculatePurchaseCount(int price) {
        return money / price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

}
