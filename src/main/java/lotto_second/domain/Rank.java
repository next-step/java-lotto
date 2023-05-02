package lotto_second.domain;

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

    public static Rank findRank(int countOfMatch, boolean matchBonus) {
        for (Rank rank : values()) {
            if (isRankMatch(rank, countOfMatch, matchBonus)) {
                return rank;
            }
        }
        return MISS;
    }

    private static boolean isRankMatch(Rank rank, int countOfMatch, boolean matchBonus) {
        if (rank.countOfMatch != countOfMatch) {
            return false;
        }

        if (rank == SECOND) {
            return matchBonus;
        }

        if (rank == THIRD) {
            return !matchBonus;
        }

        return true;
    }

}
