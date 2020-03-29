package lotto.model;

public enum MatchingResult {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

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