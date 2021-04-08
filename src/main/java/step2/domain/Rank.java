package step2.domain;

import java.util.Arrays;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6,2_000_000_000),
    BONUS(5, 30_000_000),
    MISS(0, 0);


    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == BONUS.countOfMatch && matchBonus) {
             return Rank.BONUS;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .filter(rank -> rank != rank.BONUS)
                .findFirst()
                .orElseGet(() -> Rank.MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

}
