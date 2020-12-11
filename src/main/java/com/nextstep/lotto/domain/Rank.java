package com.nextstep.lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0L, false),
    FIFTH(3, 5_000L, false),
    FOURTH(4, 50_000L, false),
    THIRD(5, 1_500_000L, false),
    SECOND(5, 30_000_000L, true),
    FIRST(6, 2_000_000_000L, false);

    private static final String DESCRIPTION_HEADER = "개 일치 (";
    private static final String DESCRIPTION_FOOTER = "원)";

    private final int numberOfMatchedNumber;
    private final Money money;
    private final boolean hasBonus;
    private final String description;

    Rank(final Integer numberOfMatchedNumber, final Long moneyValue, final boolean hasBonus) {
      this.numberOfMatchedNumber = numberOfMatchedNumber;
      this.money = new Money(moneyValue);
      this.description = numberOfMatchedNumber.toString() +
              DESCRIPTION_HEADER +
              moneyValue.toString() +
              DESCRIPTION_FOOTER;
      this.hasBonus = hasBonus;
    }

    public static Rank find(final int numberOfMatchedNumber, final boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchedNumber(numberOfMatchedNumber, rank) && doesHaveBonus(hasBonus, rank))
                .findAny()
                .orElse(NOTHING);
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

    private static boolean doesHaveBonus(final boolean hasBonus, final Rank rank) {
        return rank.hasBonus == hasBonus;
    }
}
