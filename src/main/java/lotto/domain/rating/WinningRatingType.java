package lotto.domain.rating;

import lotto.domain.winning.WinningCount;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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

    public int getReward() {
        return reward;
    }

    public static WinningRatingType findBy(int count) {
        return Arrays.stream(values())
                .filter(value -> value.count == count)
                .findFirst()
                .orElseGet(() -> WinningRatingType.LOST);
    }

    public static Map<WinningRatingType, WinningCount> toWinningCount() {
        return Arrays.stream(values())
                .collect(Collectors.toMap(
                        typeKey -> typeKey,
                        value -> new WinningCount()
                ));
    }
}
