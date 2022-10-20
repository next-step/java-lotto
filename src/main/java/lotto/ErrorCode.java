package lotto;

public enum ErrorCode {
    OUT_OF_RANGE_NUMBER("로또 숫자는 1 ~ 45 사이 입니다."),
    INCORRECT_NUMBER_COUNT("로또 티켓의 로또 숫자는 6개 입니다."),
    HAS_SAME_NUMBER("동일한 로또 숫자가 존재합니다."),
    OUT_OF_RANGE_PRICE("금액은 0보다 커야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
