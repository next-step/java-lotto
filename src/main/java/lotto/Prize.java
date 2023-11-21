package lotto;

import java.util.Arrays;

public enum Prize {
    EIGHTH(0, 0),
    SEVENTH(1, 0),
    FIFTH(2, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int rank;
    private final int price;

    Prize(int rank, int price) {
        this.rank = rank;
        this.price = price;
    }

    public static Prize prizeByMatchedCount(int matchedCount) {
        return Arrays.stream(Prize.values())
            .filter(prize -> prize.rank == matchedCount)
            .findFirst()
            .get();
    }

    public int rank() {
        return rank;
    }

    public int price() {
        return price;
    }
}
