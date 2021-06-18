package lotto.exceptions;

import lotto.common.MessageCode;

public class NumberRangeException extends RuntimeException {
    public NumberRangeException() {
        this(MessageCode.INVALID_LOTTO_NUMBER_RANGE.message());
    }

    public NumberRangeException(String message) {
        super(message);
    }
}
