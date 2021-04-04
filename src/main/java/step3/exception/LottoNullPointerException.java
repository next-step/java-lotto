package step3.exception;

public final class LottoNullPointerException extends NullPointerException {

    private final String message = "Lotto 인스턴스가 null 입니다.";

    @Override
    public String getMessage() {
        return message;
    }
}
