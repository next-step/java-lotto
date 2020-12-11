package com.nextstep.lotto.domain.exceptions;

public class NotExistLottoPrizeException extends RuntimeException {
    public NotExistLottoPrizeException(String message) {
        super(message);
    }
}
