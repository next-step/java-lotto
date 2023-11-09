package step1.exception;

public class EmptyStringException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "입력값이 공백입니다";

    public EmptyStringException() {
        super(ERROR_MESSAGE);
    }

}
