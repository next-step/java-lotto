package lotto.model;


public enum  Rank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    ZERO(0, 0);

    private int matchCount;
    private int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Rank calcRank(int matchCount, boolean isBonus) {
        if (matchCount == 6) {
            return Rank.FIRST;
        } else if (matchCount == 5 && isBonus) {
            return Rank.SECOND;
        } else if (matchCount == 4) {
            return Rank.THIRD;
        } else if (matchCount == 3) {
            return Rank.FOURTH;
        } else if (matchCount == 2) {
            return Rank.ZERO;
        }
        return Rank.ZERO;
    }
}
