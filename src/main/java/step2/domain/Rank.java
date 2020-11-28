package step2.domain;

public enum Rank {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int winPrice;

    Rank(int matchCount, int winPrice) {
        this.matchCount = matchCount;
        this.winPrice = winPrice;
    }

    public static Rank rank(int matchCount) {
        // stream 으로 줄일 수 있음
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return null;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getWinPrice() {
        return this.winPrice;
    }
}
