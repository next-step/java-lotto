package exception;

public class InvalidOperatorException extends RuntimeException {
    private static final String MESSAGE = "ERROR] 유효하지 않은 연산자입니다(%s).";

    public InvalidOperatorException(String actual) {
        super(String.format(MESSAGE, actual));
    }
}
