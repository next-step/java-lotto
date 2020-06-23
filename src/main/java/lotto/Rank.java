package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST_PLACE(6,  2_000_000_000),
    SECOND_PLACE(5,  1_500_000),
    THIRD_PLACE(4,  50_000),
    FOURTH_PLACE(3,  5_000),
    FAILURE(0,  0);

    private static final int WINNING_MIN_COUNT = 3;

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return FAILURE;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount(countOfMatch))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다."));
    }

    public Money prize(int countOfMatchLotto) {
        return new Money(countOfMatchLotto * winningMoney);
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}