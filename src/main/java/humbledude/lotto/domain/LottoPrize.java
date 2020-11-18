package humbledude.lotto.domain;

import java.util.stream.Stream;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    BLANK(0, 0);

    private final int matchedCount;
    private final long prize;

    LottoPrize(int matchedConut, long prize) {
        this.matchedCount = matchedConut;
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public static LottoPrize of(int matchedCount) {
        return Stream.of(LottoPrize.values())
                .filter(prize -> prize.getMatchedCount() == matchedCount)
                .findFirst()
                .orElse(BLANK);
    }
}
