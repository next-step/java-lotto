package step3.domain.rank;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int FIVE = 5;

    private int countOfMatch;
    private int winningMoney;

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
        Rank rank = Arrays.stream(Rank.values())
                .filter(eachRank -> eachRank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(Rank.MISS);

        if (isNoMatchBonusAtFiveCount(matchBonus, rank)) {
            rank = Rank.THIRD;
        }

        return rank;
    }

    private static boolean isNoMatchBonusAtFiveCount(boolean matchBonus, Rank rank) {
        return rank.countOfMatch == FIVE && matchBonus == false;
    }


}
