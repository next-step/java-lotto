package lotto.model;

public enum MatchingResult {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

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

    public void printHowManyMatch(long count) {
        System.out.println(matchCount + "개 일치 " + (cashPrize + "원 - ") + count + "개");
    }
}