package lotto.domain;

import java.util.Objects;

public class LottoCashPrize {
    private final int lottoCashPrize;

    public LottoCashPrize(int lottoCashPrize) {
        this.lottoCashPrize = lottoCashPrize;
    }

    public int getValue() {
        return this.lottoCashPrize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoCashPrize that = (LottoCashPrize) o;
        return lottoCashPrize == that.lottoCashPrize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoCashPrize);
    }
}
