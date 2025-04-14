package Lotto.view.message;

import java.util.ResourceBundle;

public enum Message {
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
