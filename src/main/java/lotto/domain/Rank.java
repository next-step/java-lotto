package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int match;
    private final int prize;

    Rank(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public int prize() {
        return prize;
    }

    public int match() {
        return match;
    }

    public boolean isMatch(int match) {
        return this.match == match;
    }

    public static Rank from(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(matchCount))
                .findFirst()
                .map(rank -> bonusCheck(rank, matchBonus))
                .orElse(NONE);
    }

    private static Rank bonusCheck(Rank rank, boolean matchBonus) {
        if (rank == Rank.THIRD && matchBonus) {
            return Rank.SECOND;
        }
        return rank;
    }
}
