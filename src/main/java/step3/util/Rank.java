package step3.util;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private int countOfMatch;
    private int winningMoney;
    private boolean isMatched;

    private Rank(int countOfMatch, int winningMoney, boolean isMatched) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.isMatched = isMatched;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.getCountOfMatch() == countOfMatch)
                .filter(rank -> rank.isMatched == matchBonus)
                .findFirst()
                .orElse(MISS);
    }
}