package lottogame;

import java.text.MessageFormat;

public class Payment {

    private static final int MINIMUM_MONEY = 1_000;
    private final int money;

    public Payment(String value) {
        validateBlank(value);
        int parseInt = Integer.parseInt(value);
        validateRange(parseInt);
        money = parseInt;
    }

    private void validateRange(int parseInt) {
        if (parseInt < MINIMUM_MONEY) {
            throw new IllegalArgumentException(MessageFormat.format("{0}원 이상 투입해 주세요", MINIMUM_MONEY));
        }
    }

    private void validateBlank(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
        }
    }

    public int getLottoCount() {
        return (money / MINIMUM_MONEY);
    }

    public int getMoney() {
        return money;
    }
}
