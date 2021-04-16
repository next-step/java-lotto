package lotto.domain;

import java.util.Objects;

import static lotto.exception.Message.INPUT_MONEY_MESSAGE;
import static lotto.exception.Message.MINIMUM_MONEY_MESSAGE;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private final int money;

    private Money(int money) {
        validate(money);
        this.money = money;
    }

    public static Money of(int payment) {
        return new Money(payment);
    }

    private void validate(int payment) {
        if (payment < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_MONEY_MESSAGE);
        }
        if (payment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INPUT_MONEY_MESSAGE);
        }
    }

    public int purchase() {
        return money / LOTTO_PRICE;
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
