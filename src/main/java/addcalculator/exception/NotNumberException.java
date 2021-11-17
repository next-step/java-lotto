package addcalculator.exception;

public class NotNumberException extends RuntimeException {
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자 이외의 값이 포함되어 있습니다.";

    public NotNumberException() {
        super(NOT_NUMBER_EXCEPTION_MESSAGE);
    }
}
