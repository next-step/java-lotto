package lotto.domain.result;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0)
    ;

    private int matchingCount;
    private int prize;

    Rank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank find(MatchCount matchCount, boolean isBonusBall) {
        if (SECOND.isMatchCount(matchCount)) {
            return rankSecondAndThird(isBonusBall);
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatchCount(matchCount))
                .findFirst()
                .orElse(Rank.MISS);
    }

    private static Rank rankSecondAndThird(boolean isBonusBall) {
        if (isBonusBall) {
            return SECOND;
        }
        return THIRD;
    }

    private boolean isMatchCount(MatchCount matchCount) {
        return this.matchingCount == matchCount.value();
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

}
