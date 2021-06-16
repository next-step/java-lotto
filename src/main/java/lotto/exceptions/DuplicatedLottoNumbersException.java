package lotto.exceptions;

import lotto.common.MessageCode;

public class DuplicatedLottoNumbersException extends RuntimeException {
    public DuplicatedLottoNumbersException() {
        this(MessageCode.INVALID_DUP_LOTTO_NUMBERS.message());
    }

    public DuplicatedLottoNumbersException(String message) {
        super(message);
    }
}
