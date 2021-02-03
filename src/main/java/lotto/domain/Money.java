package lotto.domain;

import lotto.utils.InputValidator;

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
        InputValidator.checkNumberValidation(amount);
        InputValidator.checkBuyPriceValidation(Integer.parseInt(amount));
    }

    public int getAmount() {
        return amount;
    }
}