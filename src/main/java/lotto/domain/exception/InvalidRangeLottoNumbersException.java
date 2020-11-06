package lotto.domain.exception;

public class InvalidRangeLottoNumbersException extends RuntimeException {
    private static final String MESSAGE = "로또 숫자는 1이상 45이하여야 합니다.";

    public InvalidRangeLottoNumbersException() {
        super(MESSAGE);
    }
}
