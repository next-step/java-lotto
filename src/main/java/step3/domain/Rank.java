package step3.domain;

import step3.exception.IllegalRankNumberException;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    SEVENTH(1, 0),
    SIXTH(2, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {

        Rank rank = Arrays.stream(values())
                .filter(r -> r.countOfMatch == countOfMatch)
                .findFirst()
                .orElseThrow(() -> new IllegalRankNumberException(IllegalRankNumberException.MESSAGE));

        if (rank.getCountOfMatch() == THIRD.getCountOfMatch() && matchBonus) {
            return SECOND;
        }

        return rank;
    }
}

