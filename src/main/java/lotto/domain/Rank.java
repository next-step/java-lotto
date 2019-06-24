package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

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

    public static Rank valueOf(int countOfMatch) {
        if (Rank.FIRST.getCountOfMatch() == countOfMatch) {
            return Rank.FIRST;
        }
        if (Rank.THIRD.getCountOfMatch() == countOfMatch) {
            return Rank.THIRD;
        }
        if (Rank.FOURTH.getCountOfMatch() == countOfMatch) {
            return Rank.FOURTH;
        }
        if (Rank.FIFTH.getCountOfMatch() == countOfMatch) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }
}
