package calculator.exception;

public class InvalidNumberException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "숫자로 변환 할 수 없습니다. : %s";

    public InvalidNumberException(final String causativeValue) {
        super(String.format(EXCEPTION_MESSAGE, causativeValue));
    }
}
