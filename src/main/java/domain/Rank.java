package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true,30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false,50_000),
    FIFTH(3, false,5_000),
    MISS(0, false,0);

    private int countOfMatch;
    private boolean needMatchBonus;
    private int winningMoney;

    private Rank(int countOfMatch, boolean needMatchBonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.needMatchBonus = needMatchBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean needMatchBonus() {
        return needMatchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if(countOfMatch == 5 && matchBonus) {
            return SECOND;
        }

        return Arrays.stream(values())
            .filter(rank -> rank.getCountOfMatch() == countOfMatch)
            .findFirst()
            .orElse(MISS);
    }
}
