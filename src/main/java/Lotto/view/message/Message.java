package Lotto.view.message;

import java.util.ResourceBundle;

public enum Message {
//    PAID_MONEY("구입금액을 입력해 주세요."),
//    WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
//    BONUS_NUMBER("보너스 볼을 입력해 주세요."),
//    MANUAL_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
//    MANUAL_NUMBERS("수동으로 구매할 번호를 입력해 주세요."),
//    VALID_NUMBER_INPUT("유효한 숫자를 입력해 주세요.");

    PAID_MONEY("message.paidMoney"),
    WINNING_NUMBERS("message.winningNumbers"),
    BONUS_NUMBER("message.bonusNumber"),
    MANUAL_COUNT("message.manualCount"),
    MANUAL_NUMBERS("message.manualNumbers"),
    VALID_NUMBER_INPUT("message.validNumberInput");

    private final String key;

    Message(String key) {
        this.key = key;
    }

    public String getMessage() {
        return ResourceBundle.getBundle("messages").getString(key);
    }
}
