package lotto.exceptions;

import lotto.domain.LottoNumber;

public class InvalidBonusNumberException extends RuntimeException {

    public InvalidBonusNumberException(LottoNumber number) {
        super("해당 보너스 번호는 당첨 번호에 이미 존재하는 번호입니다. 중복 번호 : " + number);
    }
}
