package lotto.enums;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

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

    public boolean isMiss() {
        return this == MISS;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.equals(countOfMatch)) {
                if (isSecondRank(matchBonus, rank)) {
                    return rank;
                }
            }
        }

        return MISS;
    }

    private static boolean isSecondRank(boolean matchBonus, Rank rank) {
        return !rank.equals(SECOND) || matchBonus;
    }

    public boolean equals(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}
