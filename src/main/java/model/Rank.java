package model;

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

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(LottoMatch lottoMatch) {
        Rank[] ranks = values();
        return Arrays.stream(ranks)
                .filter(rank -> lottoMatch.doesCountMatch(rank.countOfMatch))
                .findFirst()
                .map(rank -> {
                    if (rank == SECOND && !lottoMatch.isMatchBonus()) {
                        return THIRD;
                    }
                    return rank;
                })
                .orElse(MISS);
    }
}