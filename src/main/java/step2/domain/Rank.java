package step2.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean equalCountOfMatch(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (isSecond(countOfMatch, matchBonus)) {
            return SECOND;
        }
        return Arrays.stream(values())
            .filter(rank -> rank.equalCountOfMatch(countOfMatch))
            .findFirst()
            .orElse(MISS);
    }

    private static boolean isSecond(int countOfMatch, boolean matchBonus) {
        return countOfMatch == SECOND.countOfMatch && matchBonus;
    }
}