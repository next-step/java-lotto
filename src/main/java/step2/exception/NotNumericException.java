package step2.exception;

public class NotNumericException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "입력값이 숫자가 아닙니다";

    public NotNumericException() {
        super(ERROR_MESSAGE);
    }

}
