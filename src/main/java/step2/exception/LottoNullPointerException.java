package step2.exception;

public final class LottoNullPointerException extends NullPointerException {

    private final String message = "null 인 Lotto가 입력되었습니다.";

    @Override
    public String getMessage() {
        return message;
    }
}
