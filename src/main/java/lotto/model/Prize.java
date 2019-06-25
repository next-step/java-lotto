package lotto.model;

import java.util.stream.Stream;

public enum Prize {

    LOSE(0, 0),
    FOURTH(3,5_000),
    THIRD(4,50_000),
    SECOND(5,1_500_000),
    FIRST(6,2_000_000_000);

    private int countOfMatchingNumbers;
    private int prizeMoney;

    Prize(int countOfWinningNumbers, int prizeMoney) {
        this.countOfMatchingNumbers = countOfWinningNumbers;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(int countOfMatchingNumbers) {
        return Stream.of(Prize.values())
                .filter(prize -> prize.countOfMatchingNumbers == countOfMatchingNumbers)
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
