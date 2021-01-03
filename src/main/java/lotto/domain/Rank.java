package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final long countOfMatch;
    private final long winningMoney;

    Rank(long countOfMatch, long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public long getCountOfMatch() {
        return countOfMatch;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(long countOfMatch, boolean isBonus) {
        if(SECOND.countOfMatch == countOfMatch) {
            return isBonus ? SECOND : THIRD;
        }

        return Arrays.stream(Rank.values())
                .filter(Rank -> Rank.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }
}
