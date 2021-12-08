package step2.exception;

public class NotInstanceException extends RuntimeException {
    private static final String DO_NOT_INSTANCE = "인스턴스화가 불가능한 클래스입니다.";

    public NotInstanceException() {
        super(DO_NOT_INSTANCE);
    }
}
