package lotto.domain.prize;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);


    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (isSecond(countOfMatch, matchBonus)) {
            return SECOND;
        }
        return getRank(countOfMatch);
    }

    private static Rank getRank(int countOfMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.getCountOfMatch() == countOfMatch)
                return rank;
        }
        return MISS;
    }

    private static boolean isSecond(int countOfMatch, boolean matchBonus) {
        return countOfMatch == 5 && matchBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int calculateTotalPrice(int winningCount) {
        return this.winningMoney * winningCount;
    }

    @Override
    public String toString() {
        if (this == SECOND) {
            return "5개 일치, 보너스 볼 일치(30000000원)";
        }
        return this.countOfMatch + "개 일치 (" + this.winningMoney + "원)";
    }
}
