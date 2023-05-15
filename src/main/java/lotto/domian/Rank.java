package lotto.domian;

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

    public static Rank find(int matchingCount, boolean isBonusBall) {
        countValid(matchingCount);

        if (SECOND.isMatchCount(matchingCount)) {
            return rankSecondAndThird(isBonusBall);
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatchCount(matchingCount))
                .findFirst()
                .orElse(Rank.MISS);
    }

    private static Rank rankSecondAndThird(boolean isBonusBall) {
        if (isBonusBall) {
            return SECOND;
        }
        return THIRD;
    }

    private boolean isMatchCount(int matchingCount) {
        return this.matchingCount == matchingCount;
    }

    private static void countValid(int matchingCount) {
        if (matchingCount > FIRST.matchingCount || matchingCount < MISS.matchingCount) {
            throw new IllegalArgumentException("유효하지 않은 당첨번호 갯수입니다.");
        }
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

}
