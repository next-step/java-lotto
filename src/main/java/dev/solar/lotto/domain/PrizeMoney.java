package dev.solar.lotto.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiPredicate;

public enum PrizeMoney {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int count;
    private final int prizeMoney;

    PrizeMoney(final int count, final int prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public static Optional<PrizeMoney> getPrizeMoney(int count) {
        BiPredicate<PrizeMoney, Integer> filter = (x, y) -> x.count == count;

        return Arrays.stream(values())
                .filter(value -> filter.test(value, count))
                .findAny();
    }

    public int getCount() {
        return count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
