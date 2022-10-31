package lotto.domain;

import java.util.Objects;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int calculateMaxQuantity() {
        return money / LOTTO_PRICE;
    }

    public void minus(Money totalPrice) {
        this.money -= totalPrice.money;
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
