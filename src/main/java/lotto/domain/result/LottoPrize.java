package lotto.domain.result;

import lotto.vo.Money;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, new Money(2_000_000_000)),
    SECOND(5, new Money(30_000_000)),
    THIRD(5, new Money(1_500_000)),
    FOURTH(4, new Money(50_000)),
    FIFTH(3, new Money(5_000)),
    MISS(0, new Money(0));

    private final int hitCount;
    private final Money reward;

    LottoPrize(int hitCount, Money reward) {
        this.hitCount = hitCount;
        this.reward = reward;
    }

    public static LottoPrize findByMathCount(int matchCount, boolean matchBonus) {
        if (matchCount == THIRD.hitCount) {
            return findByBonus(matchBonus);
        }
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.hitCount == matchCount)
                .findAny()
                .orElse(MISS);
    }

    private static LottoPrize findByBonus(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    public Money getReward() {
        return reward;
    }

}
