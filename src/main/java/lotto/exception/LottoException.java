package lotto.exception;

import lotto.type.ExceptionType;

public class LottoException extends RuntimeException {
    private ExceptionType type;

    public LottoException(ExceptionType type) {
        super(type.getMessage());

        this.type = type;
    }
}
