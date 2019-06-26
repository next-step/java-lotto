package lotto.model;

import java.util.stream.Stream;

public enum Prize {

    LOSE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private int countOfMatchingNumbers;
    private int prizeMoney;
    private boolean hasBonusBall;

    Prize(int countOfWinningNumbers, int prizeMoney, boolean hasBonusBall) {
        this.countOfMatchingNumbers = countOfWinningNumbers;
        this.prizeMoney = prizeMoney;
        this.hasBonusBall = hasBonusBall;
    }

    public static Prize valueOf(int countOfMatchingNumbers) {
        return valueOf(countOfMatchingNumbers, false);
    }

    public static Prize valueOf(int countOfMatchingNumbers, boolean hasBonusBall) {
        return Stream.of(Prize.values())
                .filter(prize -> prize.countOfMatchingNumbers == countOfMatchingNumbers)
                .filter(prize -> prize.hasBonusBall == hasBonusBall)
                .findFirst()
                .orElse(LOSE);
    }

    public int getCountOfMatchingNumbers() {
        return countOfMatchingNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
