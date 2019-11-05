package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final boolean isMatchBonus;
    private final int winningMoney;

    Rank(final int countOfMatch, final int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.isMatchBonus = false;
        this.winningMoney = winningMoney;
    }

    Rank(final int countOfMatch, final boolean isMatchBonus, final int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.isMatchBonus = isMatchBonus;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public static Rank findByCountOfMatch(final int countOfMatch, final boolean isMatchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch && rank.isMatchBonus == isMatchBonus)
                .findAny()
                .orElse(Rank.MISS);
    }
}
