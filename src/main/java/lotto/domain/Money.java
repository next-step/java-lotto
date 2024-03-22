package lotto.domain;

import java.util.Objects;

public class Money {
    private final int money;
    public Money(String money) {
        try {
            this.money = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
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
