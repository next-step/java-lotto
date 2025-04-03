package Lotto.constants;

import java.util.Arrays;

public enum LottoPrize {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    SIX_MATCH(6, 2000000000);

    private final int matchCount;
    private final int prizeMoney;

    LottoPrize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }
    public int getMatchCount() {
        return matchCount;
    }
    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoPrize fromMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }
}
