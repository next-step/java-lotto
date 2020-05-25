package lotto.domain;

import java.util.Arrays;
import java.util.Map;

public enum LottoPrize {
    THREE_HIT(3, 5000), FOUR_HIT(4, 50000), FIVE_HIT(5, 1500000), SIX_HIT(6, 2000000000);

    private int hitCount;
    private long reward;

    LottoPrize(int hitCount, long reward) {
        this.hitCount = hitCount;
        this.reward = reward;
    }

    public static long calculateTotalReword(Map<Integer, Integer> hitResult) {
        return Arrays.stream(values())
                .filter(lottoPrize -> hitResult.containsKey(lottoPrize.hitCount))
                .map(lottoPrize -> hitResult.get(lottoPrize.hitCount) * lottoPrize.reward)
                .reduce(0L, Long::sum);
    }
}
