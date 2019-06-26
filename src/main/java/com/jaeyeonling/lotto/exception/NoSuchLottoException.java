package com.jaeyeonling.lotto.exception;

import java.util.NoSuchElementException;

public class NoSuchLottoException extends NoSuchElementException {

    private static final String ERROR_MESSAGE = "로또를 찾을 수 없습니다.";

    private NoSuchLottoException() {
        super(ERROR_MESSAGE);
    }
}
