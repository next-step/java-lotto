package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private static final String INVALID_MATCHING_COUNT_ERROR_MESSAGE = "적절하지 않은 당첨 번호 갯수입니다.";

    private final int matchingCount;
    private final long prize;

    LottoPrize(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }

    public static LottoPrize from(int matchingCount) {
        Optional<LottoPrize> lottoPrize = Arrays.stream(LottoPrize.values())
                .filter(it -> it.matchingCount == matchingCount)
                .findFirst();

        if (lottoPrize.isPresent()) {
            return lottoPrize.get();
        }

        throw new IllegalArgumentException(INVALID_MATCHING_COUNT_ERROR_MESSAGE);
    }
}
