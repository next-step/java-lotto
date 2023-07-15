package lotto.domain.game;

import java.text.MessageFormat;

public final class Payment {

    private static final int LOTTO_PRICE = 1_000;
    private final int money;

    public Payment(final int money) {
        validateRange(money);
        this.money = money;
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
