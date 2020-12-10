package com.nextstep.lotto.domain;

import java.util.Arrays;

public enum Rank {
    NOTHING(0, new Money(0L), ""),
    FOURTH(3, new Money(5_000L), "3개 일치 (5000원)"),
    THIRD(4, new Money(50_000L), "4개 일치 (50000원)"),
    SECOND(5, new Money(1_500_000L), "5개 일치 (1500000원)"),
    FIRST(6, new Money(2_000_000_000L), "6개 일치 (2000000000원)");

    private final int numberOfMatchedNumber;
    private final Money money;
    private final String description;

    Rank(int numberOfMatchedNumber, Money money, String description) {
        this.numberOfMatchedNumber = numberOfMatchedNumber;
        this.money = money;
        this.description = description;
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
