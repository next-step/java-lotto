package lotto.exception;

import static java.lang.String.format;
import static lotto.domain.LottoGame.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

public class WinningLottoNumberCountException extends RuntimeException {
    public WinningLottoNumberCountException() {
        super(format("당첨 번호는 중복 되지 않는 %d에서 %d 사이의 번호 %d자리를 입력 해야 합니다.",
                MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT));
    }
}
