package lotto.step3.domain;

public enum Rank {
    NONE(0, 0),
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

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank getRankBy(int countOfMatch, boolean isContainBonusBall) {
        if (countOfMatch == FIFTH.countOfMatch) {
            return Rank.FIFTH;
        }
        if (countOfMatch == FOURTH.countOfMatch) {
            return Rank.FOURTH;
        }
        if (countOfMatch == SECOND.countOfMatch && isContainBonusBall) {
            return Rank.SECOND;
        }
        if (countOfMatch == THIRD.countOfMatch) {
            return Rank.THIRD;
        }
        if (countOfMatch == FIFTH.countOfMatch) {
            return Rank.FIRST;
        }
        return Rank.NONE;
    }
}
