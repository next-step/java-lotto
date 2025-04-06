package com.nextstep.camp.lotto.domain.exception;

public class LottoNumberInputRegexException extends IllegalArgumentException {

    private static final String MESSAGE = "로또 번호 입력 형식이 올바르지 않습니다. ";

    public LottoNumberInputRegexException() {
        super(MESSAGE);
    }
}
