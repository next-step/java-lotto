package lotto.enums;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private long winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int matchCount, boolean bonus) {
        if (bonus && SECOND.countOfMatch == matchCount) {
            return SECOND;
        }

        for (Rank rank : Rank.values()) {
            if (rank.countOfMatch == matchCount) {
                return rank;
            }
        }
        return MISS;
    }

    public long getTotalReward(int count) {
        return count * winningMoney;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public String toString() {
        if (this == SECOND)
            return countOfMatch + "개 일치, 보너스 볼 일치 (" + getWinningMoney() + "원) - ";
        return countOfMatch + "개 일치 (" + getWinningMoney() + "원) - ";
    }
}
