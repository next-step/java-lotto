package lotto.exceptions;

public class InvalidLottoCountException extends IllegalArgumentException{
    private static final String MESSAGE = "로또 번호는 6자리여야 합니다.";

    public InvalidLottoCountException() {
        super(MESSAGE);
    }

    public InvalidLottoCountException(String message) {
        super(message);
    }
}
