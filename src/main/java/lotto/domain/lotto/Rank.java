package lotto.domain.lotto;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final long prize;

    Rank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public long getPrize() {
        return this.prize;
    }

    public static Rank find(int matchCount, boolean matchBonus) {
        Rank rank = Arrays.stream(Rank.values())
            .filter(targetRank -> targetRank.matchCount == matchCount)
            .findFirst().orElse(NONE);

        if (rank == Rank.SECOND && !matchBonus) {
            return Rank.THIRD;
        }
        return rank;
    }
}
