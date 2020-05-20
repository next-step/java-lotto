package lotto.domain.prize;

import java.util.EnumMap;

public class LottoPrizeResult {

    private static final int DEFAULT_MATCHED_COUNT = 0;

    private final EnumMap<Prize, Integer> matchedPrizes;

    private LottoPrizeResult() {
        this.matchedPrizes = new EnumMap<>(Prize.class);
        for (Prize rank : Prize.values()) {
            matchedPrizes.put(rank, DEFAULT_MATCHED_COUNT);
        }
    }

    public static LottoPrizeResult init() {
        return new LottoPrizeResult();
    }
}
