package lotto;

import java.util.Arrays;

public enum Prize {
    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    SIXTH(6, 2000000000);

    private final int rank;
    private final int price;

    Prize(int rank, int price) {
        this.rank = rank;
        this.price = price;
    }

    public static Prize prizeByRank(int rank) {
        return Arrays.stream(Prize.values())
            .filter(prizes -> rank == prizes.rank)
            .findFirst()
            .get();
    }

    public static int priceByRank(int rank) {
        return Arrays.stream(Prize.values())
            .filter(prizes -> rank == prizes.rank)
            .findFirst()
            .get().price;
    }

    public int rank() {
        return rank;
    }

    public int prize() {
        return price;
    }
}
