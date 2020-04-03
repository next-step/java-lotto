package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
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

    public static Rank valueOf(int countOfMatch) {
        Rank rank = null;
        switch (countOfMatch) {
            case 6:
                rank = Rank.FIRST;
                break;
            case 5:
                rank = Rank.SECOND;
                break;
            case 4:
                rank = Rank.THIRD;
                break;
            case 3:
                rank = Rank.FOURTH;
                break;
            default:
                rank = Rank.MISS;
                break;
        }
        return rank;
    }
}
