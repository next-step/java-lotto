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
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    static Rank valueOf(Rank rank, boolean matchBonus) {
        return valueOf(rank.countOfMatch, matchBonus);
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .filter(rank -> !rank.equals(SECOND) || matchBonus)
                .findFirst()
                .orElse(Rank.MISS);
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public boolean isMiss() {
        return this == MISS;
    }
}
