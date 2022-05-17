package lotto.exceptions;

public class InvalidManualLottoCountException extends IllegalArgumentException {
    private static final String MESSAGE = "금액이 부족합니다.";

    public InvalidManualLottoCountException() {
        super(MESSAGE);
    }

    public InvalidManualLottoCountException(String message) {
        super(message);
    }
}
