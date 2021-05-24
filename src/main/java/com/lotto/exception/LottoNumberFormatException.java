package com.lotto.exception;

public class LottoNumberFormatException extends RuntimeException {
    private static final String MESSAGE = "로또 번호 1~45의 숫자 중 6개 선택하고 쉼표(,)로 구분하여 입력해야합니다.";

    public LottoNumberFormatException() {
        super(MESSAGE);
    }

    public LottoNumberFormatException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
