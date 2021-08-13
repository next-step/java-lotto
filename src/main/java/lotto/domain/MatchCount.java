package lotto.domain;

import java.util.Arrays;

public enum MatchCount {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 15000),
    FIVE(5, 5000000),
    SIX(6, 2000000000);

    private static final String INVALID_COUNT_VALUE_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 값입니다. count: %s";

    private final int count;
    private final Money winningAmount;

    MatchCount(int count, long amount) {
        this.count = count;
        this.winningAmount = Money.of(amount);
    }

    public static MatchCount valueOf(int count) {
        return Arrays.stream(values())
                .filter(matchCount -> matchCount.isCountOf(count))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(INVALID_COUNT_VALUE_EXCEPTION_MESSAGE_FORMAT, count)));
    }

    private boolean isCountOf(int count) {
        return this.count == count;
    }

    public int getCount() {
        return count;
    }

    public Money getWinningAmount() {
        return winningAmount;
    }

    public Money calculateTotalWinningAmount(int count) {
        return winningAmount.multiply(count);
    }
}
