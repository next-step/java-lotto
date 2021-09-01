package lotto.exception;

public class InvalidNumberException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "번호는 1과 45 사이여야 합니다.";

    public InvalidNumberException() {
        super(EXCEPTION_MESSAGE);
    }
}
