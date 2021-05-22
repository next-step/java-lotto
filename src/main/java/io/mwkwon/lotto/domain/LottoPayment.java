package io.mwkwon.lotto.domain;

import java.util.Objects;

public final class LottoPayment {
    public static final int LOTTO_PRICE = 1000;
    public static final String EXCEPTION_MESSAGE = "로또 구입 가능 금액은 1000원 이상 입니다.";
    private final int value;

    public LottoPayment(int value) {
        checkMinimumLottoPayment(value);
        this.value = value;
    }

    private void checkMinimumLottoPayment(int value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public int calcLottoBuyQuantity() {
        return this.value / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPayment that = (LottoPayment) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
