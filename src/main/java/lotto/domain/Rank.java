package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final long winningMoney;

    Rank(int countOfMatch, long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(rank -> isEqualCountOfMatch(rank, countOfMatch))
                .findFirst()
                .orElse(MISS);
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return confirmRank(Rank.valueOf(countOfMatch), matchBonus);
    }

    public long multiplyMoney(int num) {
        return winningMoney * num;
    }

    public boolean isNotMiss() {
        return this != Rank.MISS;
    }

    public boolean isSecond() {
        return this == Rank.SECOND;
    }

    private static boolean isEqualCountOfMatch(Rank rank, int countOfMatch) {
        return rank.countOfMatch == countOfMatch;
    }

    private static Rank confirmRank(Rank rank, boolean matchBonus) {
        if (is2ndOr3rd(rank)) {
            return confirmBonusBall(matchBonus);
        }
        return rank;
    }

    private static boolean is2ndOr3rd(Rank rank) {
        return rank == Rank.SECOND || rank == Rank.THIRD;
    }

    private static Rank confirmBonusBall(boolean matchBonus) {
        if (matchBonus) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
