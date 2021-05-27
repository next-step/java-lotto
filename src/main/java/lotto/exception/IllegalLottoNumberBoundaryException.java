package lotto.exception;

import static java.lang.String.format;
import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

public class IllegalLottoNumberBoundaryException extends RuntimeException {
    public IllegalLottoNumberBoundaryException() {
        super(format("로또 번호는 %d와(과) %d 사이의 숫자만 가능합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
    }
}
