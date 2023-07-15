package lotto.domain;

import java.text.MessageFormat;

public final class Payment {
    private final int payment;

    public Payment(final int value, final int minPrice) {
        validateRange(value, minPrice);
        payment = value;
    }

    private void validateRange(final int value, final int minPrice) {
        if (value < minPrice) {
            throw new IllegalArgumentException(MessageFormat.format("{0}원 이상 투입해 주세요", minPrice));
        }
    }

    public float divide(float number) {
        return number / payment;
    }

    public int dividedWith(int number) {
        return payment / number;
    }

}
