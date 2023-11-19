package lotto;

import java.util.Arrays;

public enum Prize {
    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    SIXTH(6, 2000000000);

    private final int rank;
    private final int prize;

    Prize(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public static int prizeByRank(int rank) {
        return Arrays.stream(Prize.values())
            .filter(prizes -> rank == prizes.rank)
            .findFirst()
            .get().prize;
    }

    public int rank() {
        return rank;
    }

    public int prize() {
        return prize;
    }
}
