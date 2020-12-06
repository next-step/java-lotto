package lotto.domain;

import lotto.domain.exceptions.NotExistLottoPrizeException;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(6, new BigDecimal("2000000000")),
    SECOND(5, new BigDecimal("1500000")),
    THIRD(4, new BigDecimal("50000")),
    FOURTH(3, new BigDecimal("5000"));

    private final int numberOfMatchedNumber;
    private final BigDecimal prizeAmount;

    Rank(int numberOfMatchedNumber, BigDecimal prizeAmount) {
        this.numberOfMatchedNumber = numberOfMatchedNumber;
        this.prizeAmount = prizeAmount;
    }

    public static Rank find(final int numberOfMatchedNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> isSameMatchedNumber(numberOfMatchedNumber, rank))
                .findAny()
                .orElseThrow(() -> new NotExistLottoPrizeException("해당하는 당첨결과가 없습니다."));
    }

    private static boolean isSameMatchedNumber(int numberOfMatchedNumber, Rank rank) {
        return rank.numberOfMatchedNumber == numberOfMatchedNumber;
    }
}
