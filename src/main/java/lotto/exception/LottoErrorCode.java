package lotto.exception;

import exception.ErrorCode;
import lotto.Lotto;
import lotto.LottoNumber;

public enum LottoErrorCode implements ErrorCode {
    LOTTO_NUMBER_BAD_REQUEST("로또는 " + LottoNumber.MINIMUM_VALUE + "에서 " + LottoNumber.MAXIMUM_VALUE + "사이의 값만 입력가능합니다."),
    LOTTO_SIZE_BAD_REQUEST("로또 숫자는 " + Lotto.SELECT_SIZE + "개만 선택 가능합니다.");

    private final String message;

    LottoErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
