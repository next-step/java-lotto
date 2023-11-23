package lotto.domain;

public enum Prize {
    THREE_MATCHING(3, 5_000),
    FOUR_MATCHING(4, 50_000),
    FIVE_MATCHING(5, 1_500_000),
    SIX_MATCHING(6, 2_000_000_000),
    NOTHING(0, 0),
    ;

    private final int matchingCount;
    private final int prizeAmount;

    Prize(int matchingCount, int prizeAmount) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
    }

    public boolean isSameCount(int matchingCount) {
       return this.matchingCount == matchingCount;
    }

    public int calculatePrizeByCount(int count) {
        return prizeAmount * count;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
