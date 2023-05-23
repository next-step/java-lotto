package step2.domain;

import java.util.Objects;

public class Money {
    private int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("잔액은 음수를 가질 수 없습니다.");
        }
        this.money = money;
    }

    public int pay(int cost) {
        if (cost > this.money) {
            throw new IllegalArgumentException("잔액을 초과하셨습니다.");
        }
        this.money -= cost;
        return 0;
    }

    public int balance() {
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
