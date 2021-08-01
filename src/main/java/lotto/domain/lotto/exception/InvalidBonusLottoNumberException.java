package lotto.domain.lotto.exception;

public class InvalidBonusLottoNumberException extends RuntimeException {

    private static final String MESSAGE = "유효하지 않은 보너스 로또 번호입니다.";

    public InvalidBonusLottoNumberException() {
        super(MESSAGE);
    }
}
