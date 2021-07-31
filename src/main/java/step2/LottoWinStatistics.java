package step2;

public enum LottoWinStatistics {
    THREE_MATCH(5000, 0),
    FOUR_MATCH(50000, 0),
    FIVE_MATCH(1500000, 0),
    SIX_MATCH(2000000000, 0);

    private final int MATCH_PRICE;
    private int matchCount;

    LottoWinStatistics(int matchPrice, int matchCount) {
        this.MATCH_PRICE = matchPrice;
        this.matchCount = matchCount;
    }

    public void matchCountUp() {
        this.matchCount += 1;
    }
}
