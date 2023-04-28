package step2.domain.model;

import java.util.Arrays;

import static step2.domain.ProfitCalculatorService.*;


public enum WinningAmountByRank {
    FIRST(FIRST_PLACE, 2000000000, "FIRST_PLACE"),
    SECOND(SECOND_PLACE, 1500000, "SECOND_PLACE"),
    THIRD(THIRD_PLACE, 50000, "THIRD_PLACE"),
    FOURTH(FOURTH_PLACE, 5000, "FOURTH_PLACE"),
    EMPTY(EMPTY_PLACE, 0, "EMPTY_PLACE");

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