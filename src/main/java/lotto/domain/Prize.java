package lotto.domain;

public enum Prize {
    THREE_MATCHING(3, 5000),
    FOUR_MATCHING(4, 50000),
    FIVE_MATCHING(5, 1500000),
    SIX_MATCHING(6, 2000000000),
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
