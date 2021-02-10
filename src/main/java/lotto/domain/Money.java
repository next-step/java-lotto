package lotto.domain;

import lotto.resources.ErrorMessages;

public class Money {
    private final static int LOTTO_PRICE = 1_000;
    private final int amount;

    public Money(final int amount){
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validate(final int amount){
        if(amount < LOTTO_PRICE){
            throw new IllegalArgumentException(ErrorMessages.MONEY_BOUNDARY_ERROR_MESSAGE);
        }
    }
}
