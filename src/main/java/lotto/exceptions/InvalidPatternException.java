package lotto.exceptions;

import lotto.enums.ErrorMessage;

public class InvalidPatternException extends RuntimeException {

    public InvalidPatternException() {
        this(ErrorMessage.INVALID_PATTERN.toString());
    }

    public InvalidPatternException(String message) {
        super(message);
    }

}
