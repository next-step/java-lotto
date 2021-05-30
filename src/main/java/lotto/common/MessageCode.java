package lotto.common;

public enum MessageCode {
    INVALID_LOTTO_NUMBER_RANGE("1부터 45까지 숫자만 입력 가능합니다."),
    INVALID_LOTTO_NUMBER_TYPE("숫자만 입력 가능합니다.");

    private final String message;

    MessageCode(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
