package lotto.exception;

import exception.ErrorCode;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberRange;

public enum LottoErrorCode implements ErrorCode {
    LOTTO_NUMBER_BAD_REQUEST("로또는 " + LottoNumberRange.MINIMUM_VALUE
            + "에서 " + LottoNumberRange.MAXIMUM_VALUE + "사이의 값만 입력가능합니다."),
    LOTTO_SIZE_BAD_REQUEST("로또 숫자는 " + Lotto.SELECT_SIZE + "개만 선택 가능합니다."),
    LOTTO_NUMBER_OVERLAP("중복된 숫자가 포함되어 있습니다."),
    LOTTO_MANUAL_NUMBER_OUT_OF_LANGE("구매 금액을 초과했습니다.");

    private final String message;

    LottoErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
