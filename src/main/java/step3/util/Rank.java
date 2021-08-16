package step3.util;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

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

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == Rank.FIRST.getCountOfMatch()) {
            return FIRST;
        }
        if (countOfMatch == Rank.SECOND.getCountOfMatch() && matchBonus) {
            return SECOND;
        }
        if (countOfMatch == Rank.THIRD.getCountOfMatch() && !matchBonus) {
            return THIRD;
        }
        if (countOfMatch == Rank.FOURTH.getCountOfMatch()) {
            return FOURTH;
        }
        if (countOfMatch == Rank.FIFTH.getCountOfMatch()) {
            return FIFTH;
        }
        return MISS;
    }
}