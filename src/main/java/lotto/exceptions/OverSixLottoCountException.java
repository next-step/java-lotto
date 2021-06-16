package lotto.exceptions;

import lotto.common.MessageCode;

public class OverSixLottoCountException extends RuntimeException {
    public OverSixLottoCountException() {
        this(MessageCode.INVALID_OVER_LOTTO_NUMBERS.message());
    }

    public OverSixLottoCountException(String message) {
        super(message);
    }
}
