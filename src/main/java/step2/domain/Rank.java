package step2.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public enum Rank {
    FIRST(6, Money.of(2_000_000_000)), //
    SECOND(5, Money.of(30_000_000), false), //
    THIRD(5, Money.of(1_500_000)), //
    FORTH(4, Money.of(50_000)),  //
    FIFTH(3, Money.of(5_000)),  //
    MISS(0, Money.of(0));

    private final int matchingCount;
    private final Money prizeAmount;

    private final boolean exactMatch;

    Rank(int matchingCount, Money prizeAmount) {
        this(matchingCount, prizeAmount, true);
    }

    Rank(int matchingCount, Money prizeAmount, boolean exactMatch) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
        this.exactMatch = exactMatch;
    }

    public static Rank valueFrom(int matchCount) {
        int availableMatchCount = getAvailableMatchCount(matchCount);
        return valuesOnlyExactMatch() //
                .stream()
                .filter(value -> value.matchingCount == availableMatchCount) //
                .findFirst() //
                .orElseThrow(OutOfMatchingBoundaryException::new);
    }

    public static Rank valueWithBonusNumberFrom(int matchCount) {
        if (matchCount == 5) {
            return Rank.SECOND;
        }
        return valueFrom(matchCount);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public Money getPrizeAmount() {
        return prizeAmount;
    }

    private boolean isExactMatch() {
        return exactMatch;
    }

    private static int getAvailableMatchCount(int matchCount) {
        if (matchCount < 3) {
            return 0;
        }
        return matchCount;
    }

    private static List<Rank> valuesOnlyExactMatch() {
        return Arrays.stream(values()) //
                .filter(Rank::isExactMatch) //
                .collect(toList());
    }
}
