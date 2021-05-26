package lotto.exceptions;

import lotto.enums.ErrorMessage;

public class DuplicateNumbersException extends RuntimeException {

    public DuplicateNumbersException() {
        this(ErrorMessage.DUPLICATE_NUMBERS.toString());
    }

    public DuplicateNumbersException(String message) {
        super(message);
    }

}
