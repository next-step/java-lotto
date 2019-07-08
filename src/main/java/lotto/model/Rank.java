package lotto.model;

import java.util.stream.Stream;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

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

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {

        if (countOfMatch < 3) {
            return MISS;
        }

        Rank rank = Stream.of(values())
                .filter(value -> value.getCountOfMatch() == countOfMatch)
                .findFirst().orElseThrow(IllegalAccessError::new);

        if (matchBonus && rank.getCountOfMatch() == 5) {
            return SECOND;
        }

        if (rank.getCountOfMatch() == 5) {
            return THIRD;
        }

        return rank;
    }
}
