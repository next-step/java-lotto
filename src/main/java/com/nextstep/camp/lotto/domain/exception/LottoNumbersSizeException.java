package com.nextstep.camp.lotto.domain.exception;

public class LottoNumbersSizeException extends RuntimeException {

    private static final String MESSAGE = "로또 번호는 6개여야 합니다.";

    public LottoNumbersSizeException() {
        super(MESSAGE);
    }
}
