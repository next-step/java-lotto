package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTHING(2, 0);

    private final long count;
    private final long reward;

    Rank(long count, long reward) {
        this.count = count;
        this.reward = reward;
    }

    public long getCount() {
        return count;
    }

    public long getReward() {
        return reward;
    }

    public static Rank of(long count) {
        return Arrays.stream(Rank.values())
                .filter((Rank rank) -> rank.count == count)
                .findFirst()
                .orElse(NOTHING);
    }
}
