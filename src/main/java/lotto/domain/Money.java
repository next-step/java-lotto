package lotto.domain;

import lotto.utils.Validator;

public class Money {
    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public Money(String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(String amount){
        Validator.checkNumberValidation(amount);
        Validator.checkBuyPriceValidation(Integer.parseInt(amount));
    }

    public int getAmount() {
        return amount;
    }
}