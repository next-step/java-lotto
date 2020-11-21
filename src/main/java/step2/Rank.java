package step2;

import step2.domain.Money;

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

    public int getMatchingCount() {
        return matchingCount;
    }

    public Money getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isExactMatch() {
        return exactMatch;
    }

}
