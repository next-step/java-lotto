package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    MISS(0, 0, "");

    private final int matchCount;
    private final long prize;
    private final String description;

    Rank(int matchCount, long prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public int matchCount() {
        return matchCount;
    }

    public long prize() {
        return prize;
    }

    public String description() {
        return description;
    }

    public boolean isWinning() {
        return this != MISS;
    }

    public static Rank of(int matchCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.matchCount == matchCount)
            .findFirst()
            .orElse(MISS);
    }

    public static Rank[] winningRanks() {
        return Arrays.stream(values())
            .filter(Rank::isWinning)
            .toArray(Rank[]::new);
    }
}
