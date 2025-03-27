package step3.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);


    private final int matchCount;
    private final int winningMoney;

    Rank(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    private boolean hasMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }


    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5) {
            return matchBonus ? SECOND : THIRD;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.hasMatchCount(matchCount))
                .findFirst()
                .orElse(MISS);
    }
}
