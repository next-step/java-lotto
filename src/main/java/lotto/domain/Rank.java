package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FOURTH(3, 5000), THIRD(4, 50000), SECOND(5, 1500000), FIRST(6, 2000000000);

    private final int rank;
    private final int amount;

    private Rank(int rank, int amount) {
        this.rank = rank;
        this.amount = amount;
    }

    public static Optional<Rank> valueOf(int label) {
        return Arrays.stream(Rank.values())
                .filter(win -> win.rank == label)
                .findFirst();
    }

    public int getRank() {
        return rank;
    }

    public int getAmount() {
        return amount;
    }

}
