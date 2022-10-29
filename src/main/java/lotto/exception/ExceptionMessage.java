package lotto.exception;

public enum ExceptionMessage {

    ERROR_NEGATIVE_VALUE("0 미만의 숫자는 허용되지 않습니다."),
    ERROR_OUT_OF_LOTTO_NUMBER_BOUND("1 ~ 45 외의 숫자는 허용되지 않습니다."),
    ERROR_EMPTY_VALUE("입력 값이 누락되었습니다."),
    ERROR_INVALID_VALUE_TO_CONVERT("변환할 수 없는 문자가 포함되어 있습니다."),
    ERROR_INVALID_LOTTO_NUMBER_COUNT("6개의 숫자를 입력해주세요."),
    ERROR_EMPTY_LOTTO("로또를 구매하지 않았습니다."),
    ERROR_NOT_ENOUGH_MONEY("로또를 구매할 수 없습니다."),
    ERROR_INVALID_BONUS_NUMBER("로또 당첨 번호 회의 번호를 입력해주세요."),
    ERROR_ZERO_OR_NEGATIVE_VALUE("0 이하의 숫자는 허용되지 않습니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
