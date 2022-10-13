package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int matchCount;
    private final int amount;
    private final boolean matchBonus;

    LottoPrize(final int matchCount, final int amount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.matchBonus = matchBonus;
    }

    public int matchCount() {
        return matchCount;
    }

    public int amount() {
        return amount;
    }

    public boolean matchBonus() {
        return matchBonus;
    }

    public static LottoPrize of(final int matchCount, final boolean matchBonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .filter(prize -> prize.matchBonus == isValidMatchBonusNumber(matchCount, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean isValidMatchBonusNumber(final int matchCount, final boolean matchBonus) {
        if (matchCount != 5) {
            return false;
        }
        return matchBonus;
    }
}
