package lotto.domain;

import java.util.Objects;

public class Money {
    private final int money;
    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 0원 미만일 수 없습니다");
        }
        this.money = money;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) { return false; }
        Money inputMoney = (Money) obj;
        return this.money == inputMoney.getMoney();
    }

    public int hashCode() {
        return Objects.hash(this.money);
    }

    public int getMoney() {
        return this.money;
    }
    public double calculateRate(int winningMoney) {
        return winningMoney / this.money;
    }
}
