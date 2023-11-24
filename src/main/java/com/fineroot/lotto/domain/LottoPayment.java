package com.fineroot.lotto.domain;

import com.fineroot.lotto.util.ExceptionMessage;
import com.fineroot.lotto.util.LottoUtils;
import java.util.Objects;

public class LottoPayment {

    private final int value;

    private LottoPayment(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_NEGATIVE.getMessage());
        }
        this.value = value;
    }

    public static LottoPayment from(int value) {
        return new LottoPayment(value);
    }

    public int toLotteryCount() {
        return lotteryCount();
    }

    public double divide(final double sum) {
        return sum / value;
    }

    public int toAutoLotteryCount(final int manualLotteryCount) {
        return lotteryCount() - manualLotteryCount;
    }

    private int lotteryCount() {
        return value / LottoUtils.LOTTO_EACH_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPayment that = (LottoPayment) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
