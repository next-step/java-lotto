package lotto;

public enum MatchingResult {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    SIX(2000000000);

    private long cashPrize;

    MatchingResult(long cashPrize) {
        this.cashPrize = cashPrize;
    }

    public Money calculatePrizeMoney(long count) {
        if (count == 0) {
            return new Money();
        }
        return new Money(count * cashPrize);
    }
}