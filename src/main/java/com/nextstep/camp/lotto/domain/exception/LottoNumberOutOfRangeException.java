package com.nextstep.camp.lotto.domain.exception;

public class LottoNumberOutOfRangeException extends RuntimeException {

    private static final String MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public LottoNumberOutOfRangeException() {
        super(MESSAGE);
    }
}
