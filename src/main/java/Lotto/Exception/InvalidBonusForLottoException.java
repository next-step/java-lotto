package Lotto.Exception;

import StringCalculator.Exception.CustomException;

public class InvalidBonusForLottoException extends CustomException {

    public InvalidBonusForLottoException(String message) {
        super(message);
    }

    public InvalidBonusForLottoException() {
        super("보너스 볼은 1~45사이의 숫자만 가능합니다.");
    }
}