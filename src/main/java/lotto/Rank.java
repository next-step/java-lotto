package lotto;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int sameNumberCnt;
    private int winningAmount;

    Rank(int sameNumberCnt, int winningAmount) {
        this.sameNumberCnt = sameNumberCnt;
        this.winningAmount = winningAmount;
    }

    public static Rank getRank(int countOfMatch) {
        if (countOfMatch < 3){
            return MISS;
        }

        for (Rank rank : values()) {
            if (rank.matchCount(countOfMatch)) {
                return rank;
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean matchCount(int countOfMatch) {
        return this.sameNumberCnt == countOfMatch;
    }

    public int getSameNumberCnt() {
        return sameNumberCnt;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public Money prize(int countOfMatchLotto) {
        return new Money(countOfMatchLotto * winningAmount);
    }
}
