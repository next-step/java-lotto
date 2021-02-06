package lotto.domain;

import lotto.utils.Validator;

public class Money {
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount){
        Validator.checkBuyPriceValidation(amount);
    }

    public int getAmount() {
        return amount;
    }
}