package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FORTH(50_000, 4, false),
    FIFTH(5_000, 3, false);

    private final int reward;
    private final int commonNumberCount;
    private boolean matchBonus;

    LottoPrize(final int reward, final int commonNumberCount, final boolean matchBonus) {
        this.reward = reward;
        this.commonNumberCount = commonNumberCount;
        this.matchBonus = matchBonus;
    }

    public static Optional<LottoPrize> find(int commonNumberCount, boolean bonusMatched) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> commonNumberCount == lottoPrize.commonNumberCount && (!lottoPrize.matchBonus || bonusMatched))
                .findFirst();
    }

    public int reward() {
        return this.reward;
    }

    public int commonNumberCount() {
        return this.commonNumberCount;
    }
}
