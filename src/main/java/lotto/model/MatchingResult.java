package lotto.model;

public enum MatchingResult {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private int matchCount;
    private long cashPrize;

    MatchingResult(int matchCount, long cashPrize) {
        this.matchCount = matchCount;
        this.cashPrize = cashPrize;
    }

    public Money calculatePrizeMoney(long count) {
        if (count == 0) {
            return new Money();
        }
        return new Money(count * cashPrize);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getCashPrize() {
        return cashPrize;
    }
}