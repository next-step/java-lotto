package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, new Amount(2_000_000_000)),
    SECOND(5, new Amount(30_000_000)),
    THIRD(5, new Amount(1_500_000)),
    FOURTH(4, new Amount(50_000)),
    FIFTH(3, new Amount(5_000));

    public static final String INVALID_COUNT = "올바른 당첨수가 아닙니다.";
    private int count;
    private Amount price;

    Rank(final int count, final Amount price) {
        this.count = count;
        this.price = price;
    }

    static boolean isRank(final int rightNumber) {
        return Arrays.stream(values())
                .anyMatch(v -> v.count == rightNumber);
    }

    static Rank rank(final int rightNumber, boolean bonusMatch) {
        if (SECOND.isMatchCount(rightNumber)) {
            return rankSecondAndThird(bonusMatch);
        }

        return Arrays.stream(values()).filter(rank -> rank.isMatchCount(rightNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COUNT));
    }

    private static Rank rankSecondAndThird(final boolean bonusMathch) {
        if (bonusMathch) {
            return Rank.SECOND;
        }

        return Rank.THIRD;
    }

    private boolean isMatchCount(int matchCount) {
        return this.count == matchCount;
    }

    public Amount getAmount() {
        return price;
    }

    public Amount multiply(final int count) {
        return this.price.multiply(count);
    }
}
