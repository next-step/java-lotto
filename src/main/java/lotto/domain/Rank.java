package lotto.domain;

import java.util.Arrays;

public enum Rank {

    MISS(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);


    private final int rank;
    private final int amount;

    private Rank(int rank, int amount) {
        this.rank = rank;
        this.amount = amount;
    }

    public static Rank valueOf(int label) {
        return Arrays.stream(Rank.values())
                .filter(win -> win.rank == label)
                .findFirst()
                .orElse(MISS);
    }

    public int getRank() {
        return rank;
    }

    public int getAmount() {
        return amount;
    }

}
