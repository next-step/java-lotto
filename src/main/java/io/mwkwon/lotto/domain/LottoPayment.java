package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.constant.LottoConstants;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LottoPayment {
    private static final String MINIMUM_EXCEPTION_MESSAGE = "최소 로또 구입 가능 금액은 " + LottoConstants.LOTTO_PRICE + "원 입니다.";

    private final int value;

    private LottoPayment(int value) {
        checkMinimumLottoPayment(value);
        this.value = value;
    }

    public static LottoPayment create(int value) {
        return new LottoPayment(value);
    }

    private void checkMinimumLottoPayment(int value) {
        if (value < LottoConstants.LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_EXCEPTION_MESSAGE);
        }
    }

    public int calcLottoBuyQuantity() {
        return this.value / LottoConstants.LOTTO_PRICE;
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
