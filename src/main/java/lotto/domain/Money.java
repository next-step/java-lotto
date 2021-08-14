package lotto.domain;

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
}
