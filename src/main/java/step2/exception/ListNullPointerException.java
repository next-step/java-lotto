package step2.exception;

public final class ListNullPointerException extends NullPointerException {
    private final String message = "null인 리스트가 입력되었습니다.";

    @Override
    public String getMessage() {
        return message;
    }
}
