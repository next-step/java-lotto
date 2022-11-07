package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FORTH(50_000, 4),
    FIFTH(5_000, 3);

    private final int reward;
    private final int commonNumberCount;

    LottoPrize(final int reward, final int commonNumberCount) {
        this.reward = reward;
        this.commonNumberCount = commonNumberCount;
    }

    public static Optional<LottoPrize> find(int commonNumberCount, boolean bonusMatch) {
        Optional<LottoPrize> prize = Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> commonNumberCount == lottoPrize.commonNumberCount)
                .findFirst();

        if (prize.equals(Optional.of(LottoPrize.SECOND)) && !bonusMatch) {
            return Optional.of(LottoPrize.THIRD);
        }
        return prize;
    }

    public int reward() {
        return this.reward;
    }

    public int commonNumberCount() {
        return this.commonNumberCount;
    }
}
