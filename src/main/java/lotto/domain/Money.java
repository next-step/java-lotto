package lotto.domain;

import java.util.Objects;

public class Money {
    private int money;

    public Money(String money) {
        int intMoney = toIntMoney(money);
        initialize(intMoney);
    }

    public Money(int money) {
        initialize(money);
    }

    private int toIntMoney(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘몬된 값을 입력하였습니다.");
        }
    }

    private void initialize(int money) {
        if (money < 1) {
            throw new IllegalArgumentException("음수 또는 0이 아닌 숫자를 입력해주세요.");
        }
        this.money = money;
    }

    public int divideByUnit(int unit) {
        return money % unit;
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
