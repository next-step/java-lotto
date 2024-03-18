package model;

import java.util.Arrays;

public enum Rank {

    NONE(0, 0),
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(150_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3);

    private final int amount;
    private final int matchingCount;

    Rank(final int amount, final int matchingCount) {
        this.amount = amount;
        this.matchingCount = matchingCount;
    }

    public static Rank determine(final int count, final boolean isMatchBonusNumber) {
        if (isSecondRank(count, isMatchBonusNumber)) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != SECOND && rank.matchingCount == count)
                .findFirst()
                .orElse(NONE);
    }

    public int multiply(final int matchingCount) {
        return amount * matchingCount;
    }

    private static boolean isSecondRank(final int count, final boolean isMatchBonusNumber) {
        return count == SECOND.matchingCount && isMatchBonusNumber;
    }

    public int getAmount() {
        return amount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
