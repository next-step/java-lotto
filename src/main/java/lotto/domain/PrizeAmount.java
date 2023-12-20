package lotto.domain;

import java.util.Arrays;

public enum PrizeAmount {
    ZERO_DUPLICATE_PRIZE_AMOUNT(0, 0),
    ONE_DUPLICATE_PRIZE_AMOUNT(1, 0),
    TWO_DUPLICATE_PRIZE_AMOUNT(2, 0),
    THREE_DUPLICATE_PRIZE_AMOUNT(3, 5000),
    FOUR_DUPLICATE_PRIZE_AMOUNT(4, 50_000),
    FIVE_DUPLICATE_PRIZE_AMOUNT(5, 1_500_000),
    SIX_DUPLICATE_PRIZE_AMOUNT(6, 2_000_000_000);

    private final int duplicateCount;
    private final int prizeAmount;

    PrizeAmount(int duplicateCount, int prizeAmount) {
        this.duplicateCount = duplicateCount;
        this.prizeAmount = prizeAmount;
    }

    public static int calculate(int duplicateCount, int lottoNumbersCount) {
        return findPrizeAmount(duplicateCount) * lottoNumbersCount;
    }

    private static int findPrizeAmount(int duplicateCount) {
        return Arrays.stream(PrizeAmount.values())
                     .filter(prizeAmount -> prizeAmount.duplicateCount == duplicateCount)
                     .findFirst()
                     .map(prizeAmount -> prizeAmount.prizeAmount)
                     .orElse(0);
    }

}
