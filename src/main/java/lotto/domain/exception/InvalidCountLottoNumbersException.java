package lotto.domain.exception;

public class InvalidCountLottoNumbersException extends RuntimeException {
    private static final String MESSAGE = "로또 숫자는 6개여야 합니다.";

    public InvalidCountLottoNumbersException() {
        super(MESSAGE);
    }
}
