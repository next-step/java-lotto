package net.chandol.lotto.domain;

import java.util.Objects;

public enum LottoPrize {
    _1(6, 2_000_000_000),
    _2(5, 1_500_000),
    _3(4, 50_000),
    _4(3, 5_000),
    NONE(null, 0);

    private Integer matchCount;
    private Integer prize;

    public Integer getPrize() {
        return prize;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    LottoPrize(Integer matchCount, Integer prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoPrize getMatchingPrize(int count) {
        for (LottoPrize prize : LottoPrize.values()) {
            if (Objects.equals(count, prize.matchCount)) {
                return prize;
            }
        }

        return NONE;
    }
}
