package lotto.exception;

public class InvalidLottoNumberCountException extends IllegalArgumentException {
    private static final String MESSAGE = "로또 숫자는 반드시 6개 여야 합니다.";

    public InvalidLottoNumberCountException() {
        super(MESSAGE);
    }
}
