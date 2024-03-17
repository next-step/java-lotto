package lotto.validation;

import lotto.exception.InvalidLottoException;

import static lotto.model.LottoNumber.MAX_NUMBER;
import static lotto.model.LottoNumber.MIN_NUMBER;

public class LottoNumberValidator {

    public static void assertInvalidNumber(int number) {
        if (number < MIN_NUMBER || MAX_NUMBER < number) {
            throw new InvalidLottoException("로또 번호는 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이의 숫자만 선택 가능합니다");
        }
    }

}
