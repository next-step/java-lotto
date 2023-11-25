package com.fineroot.lotto.domain.vo;

import com.fineroot.lotto.util.ExceptionMessage;
import java.util.Objects;

public class LotteryCount {
    private final int value;

    private LotteryCount(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTERY_COUNT_NEGATIVE_INPUT.getMessage());
        }
        this.value = value;
    }

    public static LotteryCount from(final int value) {
        return new LotteryCount(value);
    }

    public boolean isLessThan(LotteryCount o) {
        return this.value < o.value;
    }

    public boolean isGreaterThanFromInteger(final int value) {
        return this.value > value;
    }

    public LotteryCount subtract(LotteryCount o) {
        return new LotteryCount(this.value - o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LotteryCount that = (LotteryCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
