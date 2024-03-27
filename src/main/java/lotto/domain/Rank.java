package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private int matchCount;
    private int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public static Rank valueOf(int matchCount) {
        return Arrays.stream(values())
                    .filter((rank) -> rank.matchCount == matchCount)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("실패"));
    }
}
