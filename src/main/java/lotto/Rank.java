package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchNumberCount;
    private final long winPrice;

    Rank(int matchNumberCount, long winPrice) {
        this.matchNumberCount = matchNumberCount;
        this.winPrice = winPrice;
    }

    public static Rank getRank(int matchNumberCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchNumberCount == matchNumberCount)
                .findFirst()
                .map(rank -> {
                    if (rank.matchNumberCount == 5 && !matchBonus) {
                        return THIRD;
                    }
                    return rank;
                })
                .orElse(NONE);
    }

    public long getWinPrice() {
        return winPrice;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }
}
