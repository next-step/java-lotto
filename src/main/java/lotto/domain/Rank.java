package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0),
    ;

    private static final String INVALID_COUNT_VALUE_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 값입니다. count: %s";

    private final int countOfMatch;
    private final Money winningMoney;

    Rank(int countOfMatch, long amount) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = Money.of(amount);
    }

    public static Rank valueOf(int count) {
        return Arrays.stream(values())
                .filter(matchCount -> matchCount.isCountOf(count))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(INVALID_COUNT_VALUE_EXCEPTION_MESSAGE_FORMAT, count)));
    }

    private boolean isCountOf(int count) {
        return this.countOfMatch == count;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public Money calculateTotalWinningAmount(int count) {
        return winningMoney.multiply(count);
    }
}
