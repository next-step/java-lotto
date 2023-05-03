package step3.domain.model;

import java.util.Arrays;


public enum WinningAmountByRank {
    FIRST(6, 2000000000, "FIRST_PLACE"),
    BONUS(37, 30000000, "BONUS_PLACE"),
    SECOND(5, 1500000, "SECOND_PLACE"),
    THIRD(4, 50000, "THIRD_PLACE"),
    FOURTH(3, 5000, "FOURTH_PLACE"),
    EMPTY(0, 0, "EMPTY_PLACE");

    private final int rank;
    private final int amount;
    private final String key;
    WinningAmountByRank(int rank, int amount, String key) {
        this.rank = rank;
        this.amount = amount;
        this.key = key;
    }

    public static WinningAmountByRank from(int rank) {
        return Arrays.stream(values())
                .filter(value -> rank == value.rank)
                .findFirst()
                .orElse(WinningAmountByRank.EMPTY);
    }

    public int getAmount() {
        return amount;
    }

    public int getRank() {
        return rank;
    }

    public String getKey() {
        return key;
    }
}