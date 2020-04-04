package lotto.domain;

import java.util.Objects;

public class Money {

    private final int money;

    public Money(int input) {
        validate(input);
        this.money = input;
    }

    public int getMoney() {
        return new Integer(this.money);
    }

    public Money payed(Money payedMoney) {
        int leftMoney = this.money - payedMoney.getMoney();
        if (leftMoney < 0) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }
        return new Money(leftMoney);
    }

    public int getPurchasableCount(int price) {
        return money / price;
    }

    private void validate(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("돈은 마이너스일 수 없습니다.");
        }
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
