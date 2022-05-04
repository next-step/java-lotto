package lotto.domain;

import java.util.Arrays;

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

    protected static Rank valueOf(int matchOfCount) {
        return Rank.valueOf(matchOfCount, false);
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 5 && !matchBonus) {
            return Rank.THIRD;
        }

        return Arrays.stream(values())
                .filter(it -> it.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(Rank.MISS);
    }

}
