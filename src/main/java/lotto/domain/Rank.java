package lotto.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(final int countOfMatch) {
        return Arrays.stream(Rank.values())
                .filter((rank) -> rank.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(Rank.MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
