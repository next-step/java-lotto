package lotto.exceptions;

import lotto.enums.ErrorMessage;

public class InvalidNumberException extends RuntimeException {

    public InvalidNumberException() {
        this(ErrorMessage.INVALID_NUMBER.toString());
    }

    public InvalidNumberException(String message) {
        super(message);
    }

}
