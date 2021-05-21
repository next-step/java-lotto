package lotto.domain;

import java.util.Objects;

public class Money {

    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money create(String inputMoney) {
        int money;

        try {
            money = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력받은 돈은 문자가올수 없습니다.");
        }

        return new Money(money);
    }

    public int value() {
        return money;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money that = (Money) o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
