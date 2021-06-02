package lotto.exception;

import static java.lang.String.format;
import static lotto.domain.LottoGame.LOTTO_NUMBER_COUNT;

public class IllegalLottoNumberCountException extends RuntimeException {
    public IllegalLottoNumberCountException() {
        super(format("로또 번호가 %d개가 아닙니다.", LOTTO_NUMBER_COUNT));
    }
}
