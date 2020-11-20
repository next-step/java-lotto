package lotto.domain.exception;

public enum ErrorMessage {

    NOT_VALID_PRICE("원 만큼 더 필요합니다"),
    NOT_VALID_LOTTO_NUMBER("유효한 로또번호입니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}