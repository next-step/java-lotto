package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Prize(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Prize valueOf(final int countOfMatch) {
        return Arrays.stream(Prize.values())
                .filter((prize) -> prize.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(Prize.MISS);
    }
}
