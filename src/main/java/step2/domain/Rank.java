package step2.domain;

public enum Rank {
    ZERO(0, 0, "꽝"),
    FOURTH(3, 5000, "3개 일치"),
    THIRD(4, 50000, "4개 일치"),
    SECOND(5, 1500000, "5개 일치"),
    FIRST(6, 2000000000, "6개 일치");

    private int matchCount;
    private int winPrice;
    private String message;

    Rank(int matchCount, int winPrice, String message) {
        this.matchCount = matchCount;
        this.winPrice = winPrice;
        this.message = message;
    }

    public static Rank rank(int matchCount) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return ZERO;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getWinPrice() {
        return this.winPrice;
    }

    public String getMessage() {
        return this.message;
    }
}
