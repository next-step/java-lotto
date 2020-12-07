package lotto.domain;

import lotto.domain.exceptions.NotExistLottoPrizeException;

import java.util.Arrays;

public enum Rank {
    FIRST(6, new Money(2000000000L)),
    SECOND(5, new Money(1500000L)),
    THIRD(4, new Money(50000L)),
    FOURTH(3, new Money(5000L));

    private final int numberOfMatchedNumber;
    private final Money money;

    Rank(int numberOfMatchedNumber, Money money) {
        this.numberOfMatchedNumber = numberOfMatchedNumber;
        this.money = money;
    }

    public static Rank find(final int numberOfMatchedNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchedNumber(numberOfMatchedNumber, rank))
                .findAny()
                .orElseThrow(() -> new NotExistLottoPrizeException("해당하는 당첨결과가 없습니다."));
    }

    public Money multiplyPrize(final Long count) {
        return this.money.multiplyCount(count);
    }

    private static boolean isSameMatchedNumber(int numberOfMatchedNumber, Rank rank) {
        return rank.numberOfMatchedNumber == numberOfMatchedNumber;
    }
}
