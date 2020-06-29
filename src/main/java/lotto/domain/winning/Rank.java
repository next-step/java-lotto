package lotto.domain.winning;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(final int countOfMatch, final boolean isBonusMatch) {
        if (countOfMatch == SECOND.getCountOfMatch() && isBonusMatch) {
            return Rank.SECOND;
        }
        if (countOfMatch == THIRD.getCountOfMatch()) {
            return Rank.THIRD;
        }
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
