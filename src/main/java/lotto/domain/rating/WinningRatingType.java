package lotto.domain.rating;

import java.util.Arrays;

public enum WinningRatingType {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOST(0, 0);

    private final int count;
    private final int reward;

    WinningRatingType(int count, int reward) {
        this.count = count;
        this.reward = reward;
    }

    public static WinningRatingType findBy(int count) {
        return Arrays.stream(values())
                .filter(value -> value.count == count)
                .findFirst()
                .orElseGet(() -> WinningRatingType.LOST);
    }

    public int getReward() {
        return this.reward;
    }
}
