package lotto.exceptions;

import lotto.enums.ErrorMessage;

public class InsufficientNumbersException extends RuntimeException {

    public InsufficientNumbersException() {
        this(ErrorMessage.INSUFFICIENT_NUMBERS.toString());
    }

    public InsufficientNumbersException(String message) {
        super(message);
    }

}
