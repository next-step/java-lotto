package calculator.exception;

public class NegativeNumberException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "음수를 사용할 수 없습니다. : %d";

    public NegativeNumberException(final int causativeValue) {
        super(String.format(EXCEPTION_MESSAGE, causativeValue));
    }
}
