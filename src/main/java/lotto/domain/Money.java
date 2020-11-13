package lotto.domain;

import lotto.utils.validator.DividerValidator;
import lotto.utils.validator.MoneyValidator;

import java.util.Objects;

public class Money {
    private int money;

    public Money(int money) {
        MoneyValidator.validateMoney(money);
        this.money = money;
    }

    public Money(String money) {
        MoneyValidator.validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    public double divide(int divider) {
        DividerValidator.validateDivider(divider);
        return money / divider;
    }

    public double divide(Money divider) {
        return money / divider.money;
    }

    @Override
    public String toString() {
        return Integer.toString(money);
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
