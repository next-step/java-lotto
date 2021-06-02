package study.lotto.exception;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoGame;

public class WrongLottoSizeException extends RuntimeException{

    private static final String MESSAGE = "중복 없이 " + Lotto.LOTTO_SIZE +"개의 로또 번호가 아닙니다.";

    public WrongLottoSizeException() {
        super(MESSAGE);
    }
}
