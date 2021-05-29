package study.lotto.exception;

import study.lotto.domain.LottoGame;

public class WrongLottoSizeException extends RuntimeException{

    private static final String MESSAGE = "중복 없이 " +LottoGame.MARK_SIZE +"개의 로또 번호가 아닙니다.";

    public WrongLottoSizeException() {
        super(MESSAGE);
    }
}
