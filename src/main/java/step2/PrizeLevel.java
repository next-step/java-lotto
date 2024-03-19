package step2;

public enum PrizeLevel {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int prizeAmount;

    PrizeLevel(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
