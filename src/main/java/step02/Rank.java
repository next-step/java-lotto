package step02;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_MATCH(0, 0);

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    private static Rank getMatchRank(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NO_MATCH);
    }

    public static Rank getMatchRank(int matchCount, boolean matchBonus) {
        Rank matchRank = getMatchRank(matchCount);
        if (!matchBonus && matchRank.equals(Rank.SECOND)) {
            matchRank = Rank.THIRD;
        }

        return matchRank;
    }

    public static int calculate(Rank rank, int count) {
        return valueOf(rank.name()).reward * count;
    }
}

