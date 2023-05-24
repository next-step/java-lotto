package lotto;

import java.util.Arrays;

public enum LottoPricePolicy {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    SIX_MATCH(6, 2_000_000_000),
    ETC(0, 0);

    private final long matchCount;
    private final long winningAmount;

    public static long getLottoPriceByMatchCount(int input) {
        return Arrays.stream(LottoPricePolicy.values())
                .filter(t -> t.getMatchCount() == input)
                .map(LottoPricePolicy::getWinningAmount)
                .findFirst()
                .orElse(ETC.winningAmount);
    }

    LottoPricePolicy(long matchCount, long winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
