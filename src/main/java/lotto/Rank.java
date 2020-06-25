package lotto;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST_PLACE(6,  new BigDecimal(2_000_000_000)),
    SECOND_PLACE(5,  new BigDecimal(1_500_000)),
    THIRD_PLACE(4,  new BigDecimal(50_000)),
    FOURTH_PLACE(3,  new BigDecimal(5_000)),
    FAILURE(0,  new BigDecimal(0));

    private static final int WINNING_MIN_COUNT = 3;

    private final int countOfMatch;
    private final BigDecimal winningMoney;

    Rank(int countOfMatch, BigDecimal winningMoney) {
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

    public BigDecimal prize(int countOfMatchLotto) {
        return winningMoney.multiply(new BigDecimal(countOfMatchLotto));
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}