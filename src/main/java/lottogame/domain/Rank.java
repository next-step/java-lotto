package lottogame.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(Rank.FIRST_PLACE, 2_000_000_000),
    SECOND(Rank.SECOND_PLACE, 1_500_000),
    THIRD(Rank.THIRD_PLACE, 50_000),
    FOURTH(Rank.FOURTH_PLACE, 5_000),
    NONE(Rank.NONE_PLACE, 0);

    public static final int FIRST_PLACE = 6;
    public static final int SECOND_PLACE = 5;
    public static final int THIRD_PLACE = 4;
    public static final int FOURTH_PLACE = 3;
    public static final int NONE_PLACE = 0;

    private final int rank;
    private final double amount;

    Rank(int rank, double amount) {
        this.rank = rank;
        this.amount = amount;
    }

    public static Rank from(int rank) {
        return Arrays.stream(values())
                .filter(value -> rank == value.rank)
                .findFirst()
                .orElse(Rank.NONE);
    }

    public int getRank() {
        return rank;
    }

    public double getAmount() {
        return amount;
    }
}
