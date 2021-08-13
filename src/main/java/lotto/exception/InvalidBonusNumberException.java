package lotto.exception;

public class InvalidBonusNumberException extends IllegalArgumentException {
    private static final String MESSAGE = "보너스 번호가 로또 번호에 존재 합니다.";

    public InvalidBonusNumberException() {
        super(MESSAGE);
    }
}
