package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch) {
            return matchBonus ? SECOND : THIRD;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }
}

