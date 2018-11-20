package lotto.model;

import java.util.Objects;

public class Money {
    private int money;

    private Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }

        this.money = money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    public int countOfBuy(int criteriaMoney) {
        return money / criteriaMoney;
    }

    public void deduct(Money criteriaMoney) {
        if (this.money < criteriaMoney.money) {
            throw new IllegalArgumentException();
        }

        this.money -= criteriaMoney.money;
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
