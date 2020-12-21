package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getReward(int count) {
        return winningMoney * count;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {

        Rank rank = Arrays.stream(Rank.values())
                .filter(filteredRank -> filteredRank.isSame(countOfMatch))
                .findFirst()
                .orElse(MISS);

        if (rank == Rank.SECOND && !matchBonus) {
            return Rank.THIRD;
        }

        return rank;
    }

    private boolean isSame(int matchedCount) {
        return this.countOfMatch == matchedCount;
    }
}
