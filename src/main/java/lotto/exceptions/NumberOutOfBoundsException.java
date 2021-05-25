package lotto.exceptions;

import lotto.enums.ErrorMessage;

public class NumberOutOfBoundsException extends RuntimeException {

    public NumberOutOfBoundsException() {
        this(ErrorMessage.NUMBER_OUT_OF_BOUNDS.toString());
    }

    public NumberOutOfBoundsException(String message) {
        super(message);
    }

}
