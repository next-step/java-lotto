package lottogame;

import java.text.MessageFormat;

public class Payment {

    private static final int MINIMUM_MONEY = 1_000;
    private final int money;

    public Payment(String text) {
        validateBlank(text);
        int value = toValue(text);
        validateRange(value);
        money = value;
    }

    private void validateRange(int value) {
        if (value < MINIMUM_MONEY) {
            throw new IllegalArgumentException(
                MessageFormat.format("{0}원 이상 투입해 주세요", MINIMUM_MONEY));
        }
    }

    private int toValue(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("숫자를 입력해야 합니다");
        }
    }

    private void validateBlank(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("값을 입력해 주세요");
        }
    }

    public int getLottoCount() {
        return (money / MINIMUM_MONEY);
    }

    public int getMoney() {
        return money;
    }
}
