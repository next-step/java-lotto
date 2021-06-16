package lotto.exceptions;

import lotto.common.MessageCode;

public class ManualLottoCountException extends RuntimeException {
    public ManualLottoCountException() {
        this(MessageCode.INVALID_INPUT_MANUAL_LOTTO_NUMBER.message());
    }

    public ManualLottoCountException(String message) {
        super(message);
    }
}
