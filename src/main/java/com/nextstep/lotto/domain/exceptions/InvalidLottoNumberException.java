package com.nextstep.lotto.domain.exceptions;

public class InvalidLottoNumberException extends RuntimeException {
    public InvalidLottoNumberException(String message) {
        super(message);
    }
}
