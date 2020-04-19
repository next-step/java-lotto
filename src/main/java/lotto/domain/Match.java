package lotto.domain;

public enum Match {

    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000),
    FAIL(0, 0),
    ;

    private int matchCount;
    private int prizeMoney;

    Match(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Match valueOf(int matchCount) {
        // TODO: validate
        for (Match match : values()) {
            if (match.matchCount == matchCount) {
                return match;
            }
        }
        return FAIL;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
