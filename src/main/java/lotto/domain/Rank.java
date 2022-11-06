package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int FIVE_MATCH = 5;
    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int winningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks= Rank.values();

        if (countOfMatch == FIVE_MATCH) {
            return secondOrThirdRank(matchBonus);
        }

        return Arrays.stream(ranks)
                .filter(rank -> (rank.countOfMatch == countOfMatch))
                .findFirst()
                .orElse(MISS);
    }

    private static Rank secondOrThirdRank(boolean matchBonus) {
        if (matchBonus == true) {
            return SECOND;
        }
        return THIRD;
    }
}

