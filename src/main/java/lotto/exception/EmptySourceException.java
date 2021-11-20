package lotto.exception;

public class EmptySourceException extends RuntimeException {
    private static final String EMPTY_SOURCE_MESSAGE = "공백은 입력하실 수 없습니다.";

    public EmptySourceException() {
        super(EMPTY_SOURCE_MESSAGE);
    }
}
