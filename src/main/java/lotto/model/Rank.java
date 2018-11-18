package lotto.model;

import java.util.Arrays;
import java.util.Comparator;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int MIN_PRIZE_COUNT = 3;
    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < MIN_PRIZE_COUNT) {
            return Rank.MISS;
        }

        Rank matchRank = Arrays.asList(values()).stream()
            .sorted(Comparator.reverseOrder())
            .filter(rank -> rank.isMatchCount(countOfMatch))
            .map(rank -> getPrecisionRank(rank, matchBonus))
            .findFirst()
            .get();

        return matchRank;
    }

    public int calculatePrize(int count) {
        return this.winningMoney * count;
    }

    private boolean isMatchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    private static Rank getPrecisionRank(Rank rank, boolean matchBonus) {
        return rank == Rank.THIRD && matchBonus ? Rank.SECOND : rank;
    }
}
