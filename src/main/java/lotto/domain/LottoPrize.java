package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FORTH(5_000, 3);

    private final int reward;
    private final int commonNumberCount;

    LottoPrize(final int reward, final int commonNumberCount) {
        this.reward = reward;
        this.commonNumberCount = commonNumberCount;
    }

    public static Optional<LottoPrize> findByCommonNumberCount(int commonNumberCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> commonNumberCount == lottoPrize.commonNumberCount)
                .findFirst();
    }

    public int getReward() {
        return this.reward;
    }

    public int getCommonNumberCount() {
        return this.commonNumberCount;
    }
}
