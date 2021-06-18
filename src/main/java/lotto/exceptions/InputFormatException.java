package lotto.exceptions;

import lotto.common.MessageCode;

public class InputFormatException extends RuntimeException {
    public InputFormatException() {
        this(MessageCode.INVALID_INPUT_FORMAT_NUMBERS.message());
    }

    public InputFormatException(String message) {
        super(message);
    }
}
