package lotto.exception;

import static lotto.domain.number.LottoNumber.FIRST_NUMBER;
import static lotto.domain.number.LottoNumber.LAST_NUMBER;

public class InvalidLottoNumberException extends RuntimeException {

    public static final String ERROR_OUT_OF_SCOPE_MESSAGE =  "로또 숫자의 범위는 " + FIRST_NUMBER + "부터 " + LAST_NUMBER + " 사이입니다.";

    public InvalidLottoNumberException() {
        super(ERROR_OUT_OF_SCOPE_MESSAGE);
    }

}
