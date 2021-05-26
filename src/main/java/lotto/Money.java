package lotto;

import lotto.domain.Message;
import lotto.exception.CustomIllegalArgumentException;

public class Money {

    public static final int PRICE_PER_TICKET = 1000;
    private final int MINIMUM_PURCHASE_AMOUNT = 1000;
    private final int MAXIMUM_PURCHASE_AMOUNT = 100000;

    private int money;

    public Money(int amount) throws CustomIllegalArgumentException {
        checkValidInput(amount);
        checkDividable(amount);
        this.money = amount;
    }

    private void checkValidInput(int amount) throws CustomIllegalArgumentException {
        if (amount < MINIMUM_PURCHASE_AMOUNT
                || amount > MAXIMUM_PURCHASE_AMOUNT) {
            throw new CustomIllegalArgumentException(Message.ERROR_AMOUNT_OUT_OF_RANGE,
                    MINIMUM_PURCHASE_AMOUNT,
                    MAXIMUM_PURCHASE_AMOUNT);
        }
    }

    private void checkDividable(int amount) throws CustomIllegalArgumentException {
        if (amount % PRICE_PER_TICKET != 0) {
            throw new CustomIllegalArgumentException(Message.ERROR_AMOUNT_CANNOT_BE_DIVIDED,
                    PRICE_PER_TICKET);
        }
    }

    public int countOfTickets() {
        return money / PRICE_PER_TICKET;
    }
}
