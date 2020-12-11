package com.nextstep.lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, 0L),
    FOURTH(3, 5_000L),
    THIRD(4, 50_000L),
    SECOND(5, 1_500_000L),
    FIRST(6, 2_000_000_000L);

    private static final String DESCRIPTION_HEADER = "개 일치 (";
    private static final String DESCRIPTION_FOOTER = "원)";

    private final int numberOfMatchedNumber;
    private final Money money;
    private final String description;

    Rank(Integer numberOfMatchedNumber, Long moneyValue) {
      this.numberOfMatchedNumber = numberOfMatchedNumber;
      this.money = new Money(moneyValue);
      this.description = numberOfMatchedNumber.toString() +
              DESCRIPTION_HEADER +
              moneyValue.toString() +
              DESCRIPTION_FOOTER;
    }

    public static Rank find(final int numberOfMatchedNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchedNumber(numberOfMatchedNumber, rank))
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

    private static boolean isSameMatchedNumber(int numberOfMatchedNumber, Rank rank) {
        return rank.numberOfMatchedNumber == numberOfMatchedNumber;
    }
}
