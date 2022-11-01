package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FORTH(5000, 3);

    private final int reward;
    private final int winningConditionCommonNumberCount;

    LottoPrize(final int reward, final int winningConditionCommonNumberCount) {
        this.reward = reward;
        this.winningConditionCommonNumberCount = winningConditionCommonNumberCount;
    }

    public static Optional<LottoPrize> findByCommonNumberCount(int commonNumberCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> commonNumberCount == lottoPrize.winningConditionCommonNumberCount)
                .findFirst();
    }

    public int getReward() {
        return this.reward;
    }

    public int getWinningConditionCommonNumberCount() {
        return this.winningConditionCommonNumberCount;
    }
}
