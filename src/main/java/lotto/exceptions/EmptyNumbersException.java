package lotto.exceptions;

import lotto.enums.ErrorMessage;

public class EmptyNumbersException extends RuntimeException {

    public EmptyNumbersException() {
        this(ErrorMessage.EMPTY_NUMBERS.toString());
    }

    public EmptyNumbersException(String message) {
        super(message);
    }

}
