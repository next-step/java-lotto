package me.devyonghee.lotto.model;

import java.util.Arrays;

public enum Rank {

    FIRST(2_000_000_000, Lotto.NUMBER_SIZE),
    SECOND(1_500_000, Lotto.NUMBER_SIZE - 1),
    THIRD(50_000, Lotto.NUMBER_SIZE - 2),
    FOURTH(5_000, Lotto.NUMBER_SIZE - 3),
    NOTING(0, 0);

    private final int prize;
    private final int matchCount;

    Rank(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    static Rank of(long matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(Rank.NOTING);
    }

    public int prize() {
        return prize;
    }

    public int matchCount() {
        return matchCount;
    }
}
