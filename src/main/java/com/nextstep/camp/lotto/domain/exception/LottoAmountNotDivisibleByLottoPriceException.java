package com.nextstep.camp.lotto.domain.exception;

public class LottoAmountNotDivisibleByLottoPriceException extends RuntimeException {

    private static final String MESSAGE = "로또 구입 금액은 로또 가격의 배수여야 합니다.";

    public LottoAmountNotDivisibleByLottoPriceException() {
        super(MESSAGE);
    }
}
