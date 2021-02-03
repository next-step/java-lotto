package lotto.domain;

import lotto.util.Validator;

public class Money {

    private int money;

    public Money(String input) {
        Validator.isNegative(input);
        Validator.isInteger(input);
        this.money = Integer.parseInt(input);
    }

    public int getMoney() {
        return this.money;
    }
}
