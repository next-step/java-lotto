package stringcalculator.exception;

public class InvalidNumberException extends RuntimeException {

    private static final String INVALID_NUMBER_ERROR_MESSAGE = "피연산자는 숫자를 입력해야 합니다.";

    public InvalidNumberException() {
        super(INVALID_NUMBER_ERROR_MESSAGE);
    }
}
