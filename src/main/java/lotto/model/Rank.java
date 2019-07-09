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

        if (isMiss(countOfMatch)) {
            return MISS;
        }

        Rank rank = getRank(countOfMatch);

        if (isSecond(matchBonus, rank)) {
            return SECOND;
        }

        if (isThird(rank)) {
            return THIRD;
        }

        return rank;
    }

    private static Rank getRank(int countOfMatch) {
        return Stream.of(values())
                .filter(value -> value.getCountOfMatch() == countOfMatch)
                .findFirst().orElseThrow(IllegalAccessError::new);
    }

    private static boolean isMiss(int countOfMatch) {
        return countOfMatch < 3;
    }

    private static boolean isThird(Rank rank) {
        return rank.getCountOfMatch() == 5;
    }

    private static boolean isSecond(boolean matchBonus, Rank rank) {
        return matchBonus && isThird(rank);
    }
}
