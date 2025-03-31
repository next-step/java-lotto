package com.nextstep.camp.lotto.domain.exception;

public class LottoNumberDuplicatedException extends RuntimeException {

    private static final String MESSAGE = "로또 번호는 중복될 수 없습니다.";

    public LottoNumberDuplicatedException() {
        super(MESSAGE);
    }
}
