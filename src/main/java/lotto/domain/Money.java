package lotto.domain;

import java.util.Objects;
import lotto.exception.WrongMoneyExcpetion;

public class Money {

    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if(amount < 0) {
            throw new WrongMoneyExcpetion(String.format("잘못된 금액입니다. [입력금액:%d]",amount));
        }
    }

    public int value() {
        return amount;
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
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
