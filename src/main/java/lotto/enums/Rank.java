package lotto.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURCE(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        return Arrays.stream(values())
            .filter(rank -> rank.getCountOfMatch() == countOfMatch)
            .collect(Collectors.toList())
            .get(0);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String toString() {
        return countOfMatch + "개 일치 (" + getWinningMoney() + "원) - ";
    }
}
