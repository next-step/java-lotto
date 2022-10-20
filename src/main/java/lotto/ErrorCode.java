package lotto;

public enum ErrorCode {
    OUT_OF_RANGE_NUMBER("로또 숫자는 1 ~ 45 사이 입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
