package lotto.exception;

public class NotInstanceException extends RuntimeException {
    private static final String NOT_INSTANCE_EXCEPTION_MESSAGE = "인스턴스화 할 수 없습니다.";

    public NotInstanceException() {
        super(NOT_INSTANCE_EXCEPTION_MESSAGE);
    }
}
