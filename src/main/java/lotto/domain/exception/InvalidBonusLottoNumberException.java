package lotto.domain.exception;

public class InvalidBonusLottoNumberException extends RuntimeException {
    private static final String MESSAGE = "보너스볼은 당첨번호와 중복되면 안됩니다.";

    public InvalidBonusLottoNumberException() {
        super(MESSAGE);
    }
}
