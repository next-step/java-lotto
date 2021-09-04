package lotto.exception;

public class DuplicateNumberException extends RuntimeException {
    private static final String EXCEPTION_MESSAGE = "중복된 번호는 허용하지 않습니다.";

    public DuplicateNumberException() {
        super(EXCEPTION_MESSAGE);
    }
}
