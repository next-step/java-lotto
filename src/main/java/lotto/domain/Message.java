package lotto.domain;

public enum Message {

    ERROR_NON_POSITIVE_NUMBER("0 이상의 숫자만 입력해주세요."),
    ERROR_EMPTY_INPUT("빈 값이 입력되었습니다. 다시 입력해주세요."),

    ERROR_AMOUNT_OUT_OF_RANGE("%d원 이상, %d원 이하의 금액을 입력해주세요."),
    ERROR_AMOUNT_CANNOT_BE_DIVIDED("로또 가격(%d원)으로 정확히 나누어떨어지는 금액을 입력해주세요."),
    ERROR_LOTTO_NUMBER_DUPLICATED("중복된 숫자가 있습니다. 중복없이 %d개의 숫자를 입력해주세요."),
    ERROR_BONUS_NUMBER_DUPLICATED("당첨 번호와 중복되는 보너스 볼을 입력했습니다. 다른 값을 입력해주세요."),
    ERROR_LOTTO_NUMBER_WRONG_COUNT("%d개의 숫자를 입력해주세요."),
    ERROR_LOTTO_NUMBER_OUT_OF_RANGE("%d와 %d사이의 숫자를 입력해주세요."),
    ERROR_LOTTO_COUNT_OUT_OF_RANGE("%d장을 초과하여 입력할 수 없습니다."),


    REQUEST_INPUT_AMOUNT("구입금액을 입력해주세요."),
    REQUEST_MANUAL_LOTTO_TICKET_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    REQUEST_MANUAL_LOTTO_TICKETS("수동으로 구매할 번호를 입력해 주세요."),
    REQUEST_INPUT_WINNING_NUMBERS("구분자(쉼표(,) 혹은 콜론(:))를 이용하여 지난 주 당첨 번호를 입력해 주세요."),
    REQUEST_INPUT_BONUS_NUMBERS("보너스 볼을 입력해 주세요."),

    INFO_MANUAL_AUTO_COUNT("수동으로 %d장, 자동으로 %d장을 구매했습니다."),
    INFO_BEFORE_PRINT_LOTTO_RESULT("당첨 통계\n--------");

    private String text;

    Message(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
