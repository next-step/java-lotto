package step2step3.lotto.lottoTicket;

import java.util.EnumSet;

public enum Rank {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NOTHING(0, 0, false),
    ;

    private final long numberOfMatchingNumbers;
    private final long prizeAmount;

    private final boolean isMatchBonus;

    Rank(long numberOfMatchingNumbers, long prizeAmount, boolean isMatchBonus) {
        this.numberOfMatchingNumbers = numberOfMatchingNumbers;
        this.prizeAmount = prizeAmount;
        this.isMatchBonus = isMatchBonus;
    }

    public static Rank rank(long numberOfMatchingNumbers, boolean isMatchBonus) {
        return EnumSet.allOf(Rank.class)
                .stream()
                .filter(rank -> rank.isMatchRank(numberOfMatchingNumbers, isMatchBonus))
                .findFirst()
                .orElse(Rank.NOTHING);
    }

    private boolean isMatchRank(long numberOfMatchingNumbers, boolean isMatchBonus) {
        final int fiveMatchCount = 5;
        return this.numberOfMatchingNumbers == fiveMatchCount
                ? isSameMatchBonus(isMatchBonus)
                : isSameMatchCount(numberOfMatchingNumbers);
    }

    private boolean isSameMatchCount(long numberOfMatchingNumbers) {
        return this.numberOfMatchingNumbers == numberOfMatchingNumbers;
    }

    private boolean isSameMatchBonus(boolean isMatchBonus) {
        return this.isMatchBonus == isMatchBonus;
    }

    public long prizeAmount() {
        return prizeAmount;
    }

    public long numberOfMatchingNumbers() {
        return numberOfMatchingNumbers;
    }

    public boolean isNotNothing() {
        return this != NOTHING;
    }

}
