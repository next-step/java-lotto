package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum LottoCashPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),

    FIFTH(2, 0),
    SIXTH(1, 0),
    SEVENTH(0, 0);

    private final int matchedCount;
    private final int prize;

    LottoCashPrize(int matchedCount, int prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static LottoCashPrize fromMatchedCount(int count) {
        return Stream.of(values())
                .filter(prize -> prize.getMatchedCount() == count)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<LottoCashPrize> getValuablePrizes() {
        return Arrays.asList(LottoCashPrize.FIRST, LottoCashPrize.SECOND, LottoCashPrize.THIRD, LottoCashPrize.FOURTH);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrize() {
        return prize;
    }
}
