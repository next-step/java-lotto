package domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private static final Map<Integer, Rank> SIZE_TO_RANK;

    static {
        SIZE_TO_RANK = new HashMap<>();
        for (Rank rank : values()) {
            SIZE_TO_RANK.put(rank.getSize(), rank);
        }
    }

    private final int size;
    private final int amount;

    Rank(int size, int amount) {
        this.size = size;
        this.amount = amount;
    }

    public int getSize() {
        return size;
    }

    public int getAmount() {
        return amount;
    }

    public static Rank of(int size) {
        return SIZE_TO_RANK.getOrDefault(size, Rank.NONE);
    }

    public int prizeMoney(int count) {
        return this.amount * count;
    }
}
