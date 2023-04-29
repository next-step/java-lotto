package step3.domain.model;

import java.util.Arrays;


public enum WinningAmountByRank {
    FIRST(WinningAmountByRank.FIRST_PLACE, 2000000000, "FIRST_PLACE"),
    BONUS(WinningAmountByRank.BONUS_PLACE, 30000000, "BONUS_PLACE"),
    SECOND(WinningAmountByRank.SECOND_PLACE, 1500000, "SECOND_PLACE"),
    THIRD(WinningAmountByRank.THIRD_PLACE, 50000, "THIRD_PLACE"),
    FOURTH(WinningAmountByRank.FOURTH_PLACE, 5000, "FOURTH_PLACE"),
    EMPTY(WinningAmountByRank.EMPTY_PLACE, 0, "EMPTY_PLACE");

    public static final int FIRST_PLACE = 6;
    public static final int SECOND_PLACE = 5;
    public static final int THIRD_PLACE = 4;
    public static final int FOURTH_PLACE = 3;
    public static final int BONUS_PLACE = 72;
    public static final int EMPTY_PLACE = 0;

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