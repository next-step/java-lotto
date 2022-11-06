package lotto.exception;

public enum ErrorCode {
    OUT_OF_RANGE_NUMBER("로또 숫자는 1 ~ 45 사이 입니다."),
    INCORRECT_NUMBER_COUNT("로또 티켓의 로또 숫자는 6개 입니다."),
    HAS_SAME_NUMBER("동일한 로또 숫자가 존재합니다."),
    OUT_OF_RANGE_PRICE("구입금액은 1000원보다 커야 합니다."),
    AMOUNT_UNDER_ZERO("0보다 커야 합니다."),
    NULL_OR_EMPTY("입력 값이 빈 값이나 공백일 수 없습니다."),
    WRONG_NUMBER_FORMAT("숫자 포맷이 아닙니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
