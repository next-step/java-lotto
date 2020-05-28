package lotto.domain.result;

import lotto.vo.Money;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, Money.of(2_000_000_000)),
    SECOND(5, Money.of(30_000_000)),
    THIRD(5, Money.of(1_500_000)),
    FOURTH(4, Money.of(50_000)),
    FIFTH(3, Money.of(5_000)),
    MISS(0, Money.of(0));

    private final int matchCount;
    private final Money reward;

    LottoPrize(int matchCount, Money reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static LottoPrize findByMathCount(final int matchCount, final boolean matchBonus) {
        if (matchCount == THIRD.matchCount) {
            return findByBonus(matchBonus);
        }
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.matchCount == matchCount)
                .findAny()
                .orElse(MISS);
    }

    private static LottoPrize findByBonus(final boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    public Money getReward() {
        return reward;
    }

}
