package step4.domain.rank;

import java.util.Arrays;

public enum Rank {

    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private static final int FIVE = 5;

    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public final int getCountOfMatch() {
        return countOfMatch;
    }

    public final int getWinningMoney() {
        return winningMoney;
    }

    public static final Rank valueOf(long countOfMatch, boolean matchBonus) {
        Rank rank = Arrays.stream(Rank.values())
                .filter(eachRank -> eachRank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(Rank.MISS);

        if (isMatchBonusAtFiveCount(rank, matchBonus)) {
            rank = Rank.SECOND;
        }

        return rank;
    }

    private static final boolean isMatchBonusAtFiveCount(Rank rank, boolean matchBonus) {
        return rank.countOfMatch == FIVE && matchBonus;
    }


}
