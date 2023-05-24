package lotto;

import java.util.Arrays;

public enum LottoPricePolicy {

    THREE_MATCH(3, 5_000, false),
    THREE_MATCH_BONUS(3, 5_000, true),
    FOUR_MATCH(4, 50_000, false),
    FOUR_MATCH_BONUS(4, 50_000, true),
    FIVE_MATCH(5, 1_500_000, false),
    FIVE_MATCH_BONUS(5, 30_500_000, true),
    SIX_MATCH(6, 2_000_000_000, false),
    SIX_MATCH_BONUS(6, 2_000_000_000, true),
    ETC(0, 0, false);

    private final long matchCount;
    private final long winningAmount;
    private final boolean isBonusNumber;

    public static long getLottoPriceByMatchCount(int input, boolean matchBonus) {
        return Arrays.stream(LottoPricePolicy.values())
                .filter(t -> t.getMatchCount() == input)
                .filter(t -> t.isBonusNumber == matchBonus)
                .map(LottoPricePolicy::getWinningAmount)
                .findFirst()
                .orElse(ETC.winningAmount);
    }

    LottoPricePolicy(long matchCount, long winningAmount, boolean isBonus) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.isBonusNumber = isBonus;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public long getWinningAmount() {
        return winningAmount;
    }
}
