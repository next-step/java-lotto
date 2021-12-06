package lotto.domain;

import java.util.Arrays;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int count;
    private final int amount;

    Rank(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public static Rank getRank(int count, boolean isBonus) {
        if (isBonus) {
            return Rank.SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getCount() == count)
                .filter(rank -> Rank.SECOND != rank)
                .findAny()
                .orElse(Rank.MISS);
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

}
