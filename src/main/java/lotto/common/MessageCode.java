package lotto.common;

public enum MessageCode {
    INPUT_MONEY_FOR_LOTTO("구입금액을 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 볼을 입력해주세요"),
    INPUT_WINNING_LOTTO_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    INPUT_MANUAL_BUY_LOTTO_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    INPUT_MANUAL_LOTTO_NUMBERS("수동으로 구매할 번호를 입력해 주세요."),
    INVALID_LOTTO_NUMBER_RANGE("1부터 45까지 숫자만 입력 가능합니다."),
    INVALID_INPUT_MONEY("1000원 이상 입력해 주세요"),
    INVALID_INPUT_MANUAL_LOTTO_NUMBER("구매 가능한 개수를 초과했습니다."),
    INVALID_UNDER_LOTTO_NUMBER_COUNT("로또 번호는 6개보다 작습니다."),
    INVALID_DUP_LOTTO_NUMBERS("로또 번호는 중복될 수 없습니다."),
    INVALID_OVER_LOTTO_NUMBERS("로또 번호가 6개를 초과했습니다."),
    INVALID_INPUT_FORMAT_NUMBERS("입력 형식이 올바르지 않습니다.(숫자,숫자,숫자,숫자,숫자,숫자)");
    private final String message;

    MessageCode(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
