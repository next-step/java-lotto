package lotto.domain.prize;

import java.util.Arrays;

public enum Prize {
    FIRST(12, 6, 2_000_000_000L),
    SECOND(11, 5, 30_000_000L),
    THIRD(10, 5, 1_500_000L),
    FOURTH(8, 4, 50_000L),
    FIFTH(6, 3, 5_000L),
    NOTHING(0, 0, 0L)
    ;

    private final long score;
    private final long matchingBallCount;
    private final long prizeAmount;

    Prize(long score, long matchingBallCount, long prizeAmount) {
        this.score = score;
        this.matchingBallCount = matchingBallCount;
        this.prizeAmount = prizeAmount;
    }

    public static Prize getPrizeByScore(long score) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isScoreSameAs(score))
                .findAny()
                .orElse(Prize.NOTHING);
    }

    public long getMatchingBallCount() {
        return this.matchingBallCount;
    }

    private boolean isScoreSameAs(long score) {
        if (this.score == score) {
            return true;
        }
        return false;
    }

    public long getPrizeAmount() {
        return this.prizeAmount;
    }

}
