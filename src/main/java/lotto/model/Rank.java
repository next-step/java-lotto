package lotto.model;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private static final int MIN_PRIZE_COUNT = 3;
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

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < MIN_PRIZE_COUNT) {
            return Rank.MISS;
        }

        if (countOfMatch == Rank.SECOND.getCountOfMatch() && matchBonus) {
            return Rank.SECOND;
        }

        Rank result = Rank.MISS;
        for (Rank rank : values()) {
            if (rank.getCountOfMatch() == countOfMatch) {
                result = rank;
                break;
            }
        }
        return result;
    }
}
