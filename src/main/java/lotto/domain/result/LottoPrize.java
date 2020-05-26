package lotto.domain.result;

import java.util.Arrays;
import java.util.List;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int hitCount;
    private final long reward;

    LottoPrize(int hitCount, long reward) {
        this.hitCount = hitCount;
        this.reward = reward;
    }

    public static long calculateTotalReword(List<LottoPrize> statistics) {
        return statistics.stream()
                .map(LottoPrize::getReward)
                .reduce(0L, Long::sum);
    }

    public static LottoPrize findByMathCount(int matchCount) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.hitCount == matchCount)
                .findAny()
                .orElse(MISS);
    }

    public long getReward() {
        return reward;
    }

    public int getHitCount() {
        return hitCount;
    }
}
