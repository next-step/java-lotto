package lotto.domain;

import java.text.MessageFormat;

public final class Payment {
    private final int payment;

    public Payment(final int value) {
        validateRange(value);
        payment = value;
    }

    private void validateRange(final int value) {
        if (value < LottoGame.LOTTO_PRICE) {
            throw new IllegalArgumentException(MessageFormat.format("{0}원 이상 투입해 주세요", LottoGame.LOTTO_PRICE));
        }
    }

    public float calculateProfitRate(float profit) {
        return profit / payment;
    }

    public int calculateLottoCount() {
        return payment / LottoGame.LOTTO_PRICE;
    }

}
