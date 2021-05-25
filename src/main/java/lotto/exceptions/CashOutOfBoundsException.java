package lotto.exceptions;

import lotto.enums.ErrorMessage;

public class CashOutOfBoundsException extends RuntimeException {

    public CashOutOfBoundsException() {
        this(ErrorMessage.CASH_OUT_OF_BOUNDS.toString());
    }

    public CashOutOfBoundsException(String message) {
        super(message);
    }

}
