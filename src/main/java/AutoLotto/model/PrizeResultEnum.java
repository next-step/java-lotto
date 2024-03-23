package autoLotto.model;

import java.util.Arrays;

public enum PrizeResultEnum {
    THREE_MATCHED(3,5000L),
    FOUR_MATCHED(4, 50000L),
    FIVE_MATCHED(5, 1500000L),
    SIX_MATCHED(6, 2000000000L);

    private int matchedCount;
    private Long prize;

    PrizeResultEnum(int matchedCount, Long prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    private Long getPrize() {
        return prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public static Long getPrizeByMatchedCount(int index) {
        return Arrays.stream(values())
                .filter(prizeResult -> prizeResult.matchedCount == index)
                .findFirst()
                .map(PrizeResultEnum::getPrize)
                .orElse(0L);
    }
}
