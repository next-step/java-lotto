package autoLotto.model;

import java.util.Arrays;

public enum PrizeEnum {
    FIRST(6, 2000000000L, false),
    SECOND(5, 30000000L, true),
    THIRD(5, 1500000L, false),
    FOURTH(4, 50000L, false),
    FIFTH(3, 5000L, false),
    MISS(0, 0L, false);

    private int matchedCount;
    private Long prize;
    private boolean isBonusMatched;

    PrizeEnum(int matchedCount, Long prize, boolean isBonusMatched) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.isBonusMatched = isBonusMatched;
    }

    public Long getPrize() {
        return prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    public static PrizeEnum getPrizeFrom(int matchedCount, boolean isBonusMatched) {
        return Arrays.stream(values())
                .filter(prizeResult -> prizeResult.matchedCount == matchedCount)
                .filter(prizeResult -> prizeResult.isBonusMatched == isBonusMatched)
                .findFirst()
                .orElse(PrizeEnum.MISS);
    }
}
