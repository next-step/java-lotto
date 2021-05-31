package step5.domain;

import step5.exception.IllegalRankNumberException;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public static Rank rank(int matchCount, boolean matchBonus) {
        if (matchCount < FIFTH.countOfMatch) {
            return MISS;
        }

        if (SECOND.isMatchCount(matchCount)) {
            return ranksSecondAndThird(matchBonus);
        }

        return Arrays.stream(values())
                .filter(rank -> rank.isMatchCount(matchCount))
                .findFirst()
                .orElseThrow(IllegalRankNumberException::new);

    }

    private boolean isMatchCount(int matchCount) {
        return this.countOfMatch == matchCount;
    }

    private static Rank ranksSecondAndThird(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }
}


