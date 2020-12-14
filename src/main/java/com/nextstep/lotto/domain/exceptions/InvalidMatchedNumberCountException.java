package com.nextstep.lotto.domain.exceptions;

public class InvalidMatchedNumberCountException extends RuntimeException {
    public InvalidMatchedNumberCountException(String message) {
        super(message);
    }
}
