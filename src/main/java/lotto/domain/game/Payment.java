package lotto.domain.game;

import java.text.MessageFormat;
import java.util.OptionalInt;

public final class Payment {

    private static final int LOTTO_PRICE = 1_000;
    private final int money;

    public Payment(final String text) {
        int value = OptionalInt.of(Integer.parseInt(text.trim()))
            .orElseThrow(() -> new NumberFormatException("숫자를 입력해야 합니다"));
        validateRange(value);
        money = value;
    }

    private void validateRange(final int value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException(
                MessageFormat.format("{0}원 이상 투입해 주세요", LOTTO_PRICE));
        }
    }

    public int getLottoCount() {
        return (money / LOTTO_PRICE);
    }

    public int getMoney() {
        return money;
    }
}
