package lotto.domain.lotto;

import java.util.Arrays;

public enum LotteryRank {

    UNRANK(0, 0),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    private final int matchingCount;
    private final long prize;

    LotteryRank(int matchingCount, long prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static LotteryRank findRankBy(int matchingCount, boolean bonus) {
        if (bonus && SECOND.matchingCount == matchingCount) {
            return SECOND;
        }

        return Arrays.stream(values())
            .filter(val -> val.matchingCount == matchingCount)
            .findFirst()
            .orElse(UNRANK);
    }

    public int matchingCount() {
        return this.matchingCount;
    }

    public long prize() {
        return this.prize;
    }
}
