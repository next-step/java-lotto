package lotto.domain.result;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int hitCount;
    private final long reward;

    LottoPrize(int hitCount, long reward) {
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

    public long getReward() {
        return reward;
    }

    public int getHitCount() {
        return hitCount;
    }
}
