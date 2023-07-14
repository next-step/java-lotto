package lotto.domain;

import java.text.MessageFormat;

public final class Payment {

    private static final int MIN_MONEY = 1_000;
    private final int money;

    public Payment(final int value) {
        validateRange(value);
        money = value;
    }

    private void validateRange(final int value) {
        if (value < MIN_MONEY) {
            throw new IllegalArgumentException(MessageFormat.format("{0}원 이상 투입해 주세요", MIN_MONEY));
        }
    }

    public int getLottoCount() {
        return (money / MIN_MONEY);
    }

    public int getMoney() {
        return money;
    }
}
