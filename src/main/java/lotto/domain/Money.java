package lotto.domain;

import java.util.Objects;
import lotto.domain.util.LottoConstant;

public class Money {
    private int balance;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(LottoConstant.MONEY_NEGATIVE_EXCEPTION);
        }
        this.balance = money;
    }

    public boolean withdraw(int amount) {
        if (amount > balance) {
            return false;
        }
        balance = balance - amount;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return balance == money.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }
}
