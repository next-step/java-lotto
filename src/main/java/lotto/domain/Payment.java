package lotto.domain;

import java.text.MessageFormat;

public final class Payment {
    private static final int LOTTO_PRICE = 1_000;
    private final int payment;

    public Payment(final int value) {
        validateRange(value);
        payment = value;
    }

    private void validateRange(final int value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException(MessageFormat.format("{0}원 이상 투입해 주세요", LOTTO_PRICE));
        }
    }

    public float divide(float number) {
        return number / payment;
    }

    public int dividedWith(int number) {
        return payment / number;
    }

}
