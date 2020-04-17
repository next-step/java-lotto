package Lotto.domain;

import java.util.stream.Stream;

public enum  WinningType {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    WinningType(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static WinningType valueOf(int countOfMatch) {
        return Stream.of(WinningType.values())
                .filter(value-> value.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }
}
