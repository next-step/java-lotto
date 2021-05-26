package lotto.exception;

import static java.lang.String.format;
import static lotto.domain.LottoGame.LOTTO_NUMBER_COUNT;

public class IllegalLottoNumberCountException extends RuntimeException {
    public IllegalLottoNumberCountException() {
        super(format("한 게임에 로또 번호는 %d개 입니다.", LOTTO_NUMBER_COUNT));
    }
}
