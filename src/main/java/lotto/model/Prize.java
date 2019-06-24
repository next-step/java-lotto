package lotto.model;

import java.util.stream.Stream;

public enum Prize {

    FIRST(6,2000000000),
    SECOND(5,1500000),
    THIRD(4,50000),
    FOURTH(3,5000),
    LOSE(0, 0);

    private int countOfWinningNumbers;
    private int prizeMoney;

    Prize(int countOfWinningNumbers, int prizeMoney) {
        this.countOfWinningNumbers = countOfWinningNumbers;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(int countOfWinningNumbers) {
        return Stream.of(Prize.values())
                .filter(prize -> prize.countOfWinningNumbers == countOfWinningNumbers)
                .findFirst()
                .orElse(LOSE);
    }

    public int getCountOfWinningNumbers() {
        return countOfWinningNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
