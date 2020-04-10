package lotto.model;


public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 3000000),
    THIRD(5, 150000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
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
        } else if (matchCount == 5) {
            return Rank.THIRD;
        } else if (matchCount == 4) {
            return Rank.FOURTH;
        } else if (matchCount == 3) {
            return Rank.FIFTH;
        }
        return Rank.ZERO;
    }
}
