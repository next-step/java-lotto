package lotto.exception;

public class NotSupportInstanceException extends RuntimeException {

    private static final String MESSAGE = "생성자를 지원하지 않습니다.";

    public NotSupportInstanceException() {
        super(MESSAGE);
    }

    public NotSupportInstanceException(String message) {
        super(message);
    }
}
