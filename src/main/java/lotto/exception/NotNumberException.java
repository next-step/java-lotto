package lotto.exception;

public class NotNumberException extends NumberFormatException {

    private static final String MESSAGE = "숫자만 입력할 수 있습니다.";

    public NotNumberException() {
        super(MESSAGE);
    }

}
