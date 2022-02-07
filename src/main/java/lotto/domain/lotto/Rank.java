package lotto.domain.lotto;

import java.util.Arrays;

public enum Rank {

    NONE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

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

    public static Rank of(int matchCount, boolean matchBonus) {
        Rank rank = Arrays.stream(Rank.values())
            .filter(targetRank -> targetRank.matchCount == matchCount)
            .findFirst().orElse(NONE);

        if (rank == Rank.THIRD && matchBonus) {
            return Rank.SECOND;
        }
        return rank;
    }
}
