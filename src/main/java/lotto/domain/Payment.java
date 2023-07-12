package lotto.domain;

import java.text.MessageFormat;

public final class Payment {

    private static final int MIN_MONEY = 1_000;
    private final int money;

    public Payment(final String value) {
        validateBlank(value);
        money = Integer.parseInt(value);
        validateRange(money);
    }

    private void validateRange(final int parseInt) {
        if (parseInt < MIN_MONEY) {
            throw new IllegalArgumentException(MessageFormat.format("{0}원 이상 투입해 주세요", MIN_MONEY));
        }
    }

    private void validateBlank(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
        }
    }

    public int getLottoCount() {
        return (money / MIN_MONEY);
    }

    public int getMoney() {
        return money;
    }
}
