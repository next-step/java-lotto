package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),


    MISS(0, 0);

    private final int match;
    private final int winningBonus;

    Rank(int match, int winningBonus) {
        this.match = match;
        this.winningBonus = winningBonus;
    }

    public int getMatch() {
        return match;
    }

    public int getWinningBonus() {
        return winningBonus;
    }

    public static Rank of(int count) {
        if (count < FIFTH.match) {
            return MISS;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.match == count)
                .findFirst().get();
    }
}
