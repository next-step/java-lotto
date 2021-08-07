package lotto.exception;

import static lotto.model.LottoNumber.MAX_OF_LOTTO_NUMBER;
import static lotto.model.LottoNumber.MIN_OF_LOTTO_NUMBER;

public class LottoNumberRangeException extends RuntimeException {
    public LottoNumberRangeException() {
        super("lotto number must be greater than " + MIN_OF_LOTTO_NUMBER + " and less than " + MAX_OF_LOTTO_NUMBER);
    }
}
