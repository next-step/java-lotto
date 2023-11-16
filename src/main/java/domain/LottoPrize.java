package domain;

public enum LottoPrize {
    NO_MATCH(0, 0),
    ONE_MATCH(1, 0),
    TWO_MATCH(2, 0),
    THREE_MATCH(3, 5000L),
    FOUR_MATCH(4, 50000L),
    FIVE_MATCH(5, 1500000L),
    SIX_MATCH(6, 2000000000L),
    ;

    private final int matchCount;
    private final long winningPrize;

    LottoPrize(int matchCount, long winningPrize) {
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long winningPrize() {
        return winningPrize;
    }

    public static LottoPrize fromMatchCount(int num) {
        for (LottoPrize prz : values()) {
            if (prz.matchCount == num) {
                return prz;
            }
        }
        throw new IllegalArgumentException("로또의 최대 매칭가능한 갯수는 " + SIX_MATCH.matchCount + "입니다.");
    }
}
