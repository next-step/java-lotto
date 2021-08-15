package lotto.model;

import java.util.Arrays;

public enum Rank {
    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    SIXTH(6, 2000000000),
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
        if (count < THIRD.match) {
            return MISS;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.match == count)
                .findFirst().get();
    }
}
