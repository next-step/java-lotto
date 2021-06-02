package lotto.common;

public enum MessageCode {
    INVALID_LOTTO_NUMBER_RANGE("1부터 45까지 숫자만 입력 가능합니다."),
    INVALID_LOTTO_NUMBER_TYPE("숫자만 입력 가능합니다."),
    INPUT_MONEY_FOR_LOTTO("구입금액을 입력해 주세요."),
    INPUT_LAST_WON_LOTTO_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 볼을 입력해주세요"),
    INPUT_LAST_WON_BONUS_NUMBER("보너스 볼을 입력해주세요"),
    INPUT_WINNING_LOTTO_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    INPUT_MANUAL_BUY_LOTTO_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    INPUT_MANUAL_LOTTO_NUMBERS("수동으로 구매할 번호를 입력해 주세요.");

    private final String message;

    MessageCode(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
