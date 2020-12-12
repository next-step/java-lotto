package com.nextstep.lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0L),
    FIFTH(3, 5_000L),
    FOURTH(4, 50_000L),
    THIRD(5, 1_500_000L),
    SECOND(5, 30_000_000L),
    FIRST(6, 2_000_000_000L);

    private static final String DESCRIPTION_HEADER = "개 일치 (";
    private static final String DESCRIPTION_FOOTER = "원)";

    private final int numberOfMatchedNumber;
    private final Money money;
    private final String description;

    Rank(final Integer numberOfMatchedNumber, final Long moneyValue) {
      this.numberOfMatchedNumber = numberOfMatchedNumber;
      this.money = new Money(moneyValue);
      this.description = numberOfMatchedNumber.toString() +
              DESCRIPTION_HEADER +
              moneyValue.toString() +
              DESCRIPTION_FOOTER;
    }

    public static Rank find(final int numberOfMatchedNumber, final boolean hasBonus) {
        Rank candidateRank = Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchedNumber(numberOfMatchedNumber, rank))
                .findAny()
                .orElse(NOTHING);
        return confirmRank(candidateRank, hasBonus);
    }

    public Money multiplyPrize(final Long count) {
        return this.money.multiplyCount(count);
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfMatchedNumber() {
        return numberOfMatchedNumber;
    }

    private static boolean isSameMatchedNumber(final int numberOfMatchedNumber, final Rank rank) {
        return rank.numberOfMatchedNumber == numberOfMatchedNumber;
    }

    private static Rank confirmRank(final Rank candidateRank, final boolean hasBonus) {
        if (candidateRank == Rank.THIRD || candidateRank == Rank.SECOND) {
            return judgeIsSecond(hasBonus);
        }
        return candidateRank;
    }

    private static Rank judgeIsSecond(final boolean hasBonus) {
        if (hasBonus) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }
}
