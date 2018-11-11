package lotto.domain;

public enum LottoPrize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int prize;

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public int sum(int number) {
        return this.prize * number;
    }

    private boolean isMatchedCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public static LottoPrize findPrize(int matchCount, boolean hasBonusBall) {
        LottoPrize prize = valueOf(matchCount);
        if (isSecond(prize, hasBonusBall)) {
            return SECOND;
        }
        return prize;
    }

    private static boolean isSecond(LottoPrize prize, boolean hasBonusBall) {
        return THIRD == prize && hasBonusBall;
    }

    private static LottoPrize valueOf(int matchCount) {
        for (LottoPrize prize: LottoPrize.values()) {
            if (prize.isMatchedCount(matchCount)) {
                return prize;
            }
        }
        return null;
    }
}
