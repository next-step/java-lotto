package com.nextstep.lotto.lottoGame.domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(2, 0);

    private int matchCount;
    private int prize;

    Rank(final int matchCount, final int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank rank(final int matchCount, final boolean matchBonus) {
        if (matchCount < 3) {
            return NONE;
        }

        if (matchCount == SECOND.matchCount) {
            return rankSecondOrThird(matchBonus);
        }

        return Stream.of(values())
                .filter(rank -> rank.isMatchCount(matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static Rank rankSecondOrThird(final boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    public int getPrize() {
        return this.prize;
    }

    private boolean isMatchCount(final int matchCount) {
        return this.matchCount == matchCount;
    }
}
