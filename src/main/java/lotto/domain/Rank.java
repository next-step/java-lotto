package lotto.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private static final int MATCH_MIN_COUNT = 3;
    private final int countOfMatch;
    private final int winningMoney;

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
        if (countOfMatch < MATCH_MIN_COUNT) {
            return MISS;
        }

        if (SECOND.isMatch(countOfMatch)) {
            return matchBonus ? SECOND : THIRD;
        }

        return valueOf(countOfMatch);
    }

    private static Rank valueOf(int countOfMatch) {
        return Arrays.stream(Rank.values())
                .filter(v -> v.isMatch(countOfMatch))
                .findFirst()
                .orElse(MISS);
    }

    private boolean isMatch(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}
