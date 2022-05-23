package dev.solar.lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

import dev.solar.lotto.LottoException;

public enum PrizeMoney {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
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

    public static PrizeMoney rank(int count) {
        BiPredicate<PrizeMoney, Integer> filter = (x, y) -> x.count == count;

        return Arrays.stream(values())
                .filter(value -> filter.test(value, count))
                .findAny()
                .orElseThrow(() -> new LottoException("로또 일치 결과는 0 ~ 6개 사이여야합니다."));
    }

    public int getCount() {
        return count;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
