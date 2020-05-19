package exception;

public class NegativeNumberException extends RuntimeException {

    private static final String ERROR_MESSAGE = "음수는 허용하지 않습니다. [input: '%d']";

    public NegativeNumberException(int value) {
        super(String.format(ERROR_MESSAGE, value));
    }
}
