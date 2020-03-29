package lotto.model;

public enum MatchingResult {
    ZERO(0, 0),
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

    public static MatchingResult findMatchingResult(int matchCount){
        if(matchCount == 3){
            return THREE;
        }
        if(matchCount == 4){
            return FOUR;
        }
        if(matchCount == 5){
            return FIVE;
        }
        if(matchCount == 6){
            return SIX;
        }
        return ZERO;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getCashPrize() {
        return cashPrize;
    }

    public void printHowManyMatch(long count) {
        System.out.println(matchCount + "개 일치 " + (cashPrize + "원 - ") + count + "개");
    }
}