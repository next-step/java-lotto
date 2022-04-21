package lotto.exception;

import lotto.model.LottoNumber;

public class InvalidBonusNumberException extends RuntimeException {

    private static final String INVALID_BONUS_NUMBER_MESSAGE_FORMAT = "유효하지 않은 보너스 번호 입니다 : %s";

    public InvalidBonusNumberException(LottoNumber number) {
        super(String.format(INVALID_BONUS_NUMBER_MESSAGE_FORMAT, number));
    }
}
