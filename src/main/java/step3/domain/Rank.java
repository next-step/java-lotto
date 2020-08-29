package step3.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    public static final int MATCH_BONUS_COUNT_OF_MATCH = 5;

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isCountOfMatch(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == MATCH_BONUS_COUNT_OF_MATCH) {
            return matchBonus ? SECOND : THIRD;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.isCountOfMatch(countOfMatch))
                .findAny()
                .orElse(Rank.MISS);
    }

}
