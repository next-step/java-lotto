package step3.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int WIN_MIN = 3;
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

    public static Rank rank(int countOfMatch, boolean bonus) {
        Rank[] ranks = values();

        if (countOfMatch < WIN_MIN) {
            return Rank.MISS;
        }

        if (countOfMatch == SECOND.getCountOfMatch()) {
            return divideSecondThirdPrice(bonus);
        }

        for (Rank rank : ranks) {
            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }

        throw new IllegalArgumentException();

    }

    private static Rank divideSecondThirdPrice(boolean bonus) {
        if (bonus) {
            return SECOND;
        }
        return THIRD;
    }

}