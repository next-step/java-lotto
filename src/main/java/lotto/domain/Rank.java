package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    LOSING(0, 0);

    private int countOfMatch;
    private int winningMoney;

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valudOf(int countOfMatch) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(Rank.LOSING);
    }

}
