package study.lotto.exception;

import study.lotto.domain.LottoGame;

public class DuplicateBonusBallException extends RuntimeException{
    private static final String MESSAGE = "보너스 볼은 당첨 번호와 중복될 수 없습니다.";

    public DuplicateBonusBallException() {
        super(MESSAGE);
    }
}
