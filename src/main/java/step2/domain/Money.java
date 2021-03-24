package step2.domain;

import step2.domain.exception.CustomException;
import step2.domain.exception.ErrorCode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Money {
    private final int amount;

    public Money(int amount) {
        if (!valid(amount)) {
            throw new CustomException(ErrorCode.NEGATIVE_MONEY_AMOUNT);
        }
        this.amount = amount;
    }

    public final int getAmount() {
        return amount;
    }

    private boolean valid(int amount) {
        return amount >= 0;
    }

}
