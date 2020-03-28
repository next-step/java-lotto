package lotto.domain;

import java.util.Objects;

public class Money {
    private final double money;

    public Money() {
        money = 0;
    }

    public Money(double money) {
        validatePositive(money);
        this.money = money;
    }

    private void validatePositive(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 양의 정수만 입력 가능 합니다.");
        }
    }

    public Money plus(Money money) {
        return new Money(this.money + money.money);
    }

    public Money divide(Money money) {
        return new Money(this.money / money.money);
    }

    public Money multiply(Money money) {
        return new Money(this.money * money.money);
    }

    public double getMoney() {
        return money;
    }

    public int getHowManyBuyItem(Money itemPrice) {
        return (int) Math.floor(this.money / itemPrice.money);
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
