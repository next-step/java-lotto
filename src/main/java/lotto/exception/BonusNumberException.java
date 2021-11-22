package lotto.exception;

import lotto.domain.LottoNumber;

public class BonusNumberException extends RuntimeException {
    private static final String MESSAGE = "Bonus 숫자(%d)가 잘못 되었습니다.";

    public BonusNumberException(LottoNumber bonusNumber) {
        super(String.format(MESSAGE, bonusNumber.getNumber()));
    }
}
