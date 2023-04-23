package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THREE(4, 50_000),
    FOUR(3, 5_000),
    FIVE(2, 0),
    SIX(1, 0),
    NONE(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(r -> r.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(NONE);
    }
}
