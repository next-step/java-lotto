package lotto.domain;

public enum WinningPrize {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private final int matchCount;
    private final int prizeMoney;

    WinningPrize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static int getPrizeMoney(int matchCount) {
        for (WinningPrize prize : values()) {
            if (prize.getMatchCount() == matchCount) {
                return prize.getPrizeMoney();
            }
        }
        return 0;
    }
}