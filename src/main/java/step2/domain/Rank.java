package step2.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, Money.of(2_000_000_000)), //
    SECOND(5, Money.of(30_000_000)), //
    THIRD(5, Money.of(1_500_000)), //
    FORTH(4, Money.of(50_000)),  //
    FIFTH(3, Money.of(5_000)),  //
    MISS(0, Money.of(0));

    private final int matchingCount;
    private final Money prizeAmount;

    Rank(int matchingCount, Money prizeAmount) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
    }

    public static Rank valueFrom(int matchCount) {
        int availableMatchCount = getAvailableMatchCount(matchCount);
        return Arrays.stream(values()) //
                .filter(value -> value.matchingCount == availableMatchCount) //
                .findFirst() //
                .orElseThrow(OutOfMatchingBoundaryException::new);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public Money getPrizeAmount() {
        return prizeAmount;
    }

    private static int getAvailableMatchCount(int matchCount) {
        if (matchCount < 3) {
            return 0;
        }
        return matchCount;
    }
}
