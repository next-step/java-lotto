package lotto.exceptions;

import lotto.common.MessageCode;

public class MoneyNotEnoughException extends RuntimeException {
    public MoneyNotEnoughException() {
        this(MessageCode.INVALID_INPUT_MONEY.message());
    }

    public MoneyNotEnoughException(String message) {
        super(message);
    }
}
