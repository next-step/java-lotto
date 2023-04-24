package lotto.domain.rating;

import lotto.domain.winning.WinningCount;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum WinningRatingType {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int count;
    private final int reward;

    WinningRatingType(int count, int reward) {
        this.count = count;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public static WinningRatingType findBy(int count, boolean isBonus) {
        if (count == 5) {
            return decisionSecond(isBonus);
        }

        return Arrays.stream(values())
                .filter(value -> value.count == count)
                .findFirst()
                .orElseGet(() -> WinningRatingType.MISS);
    }

    private static WinningRatingType decisionSecond(boolean isBonus) {
        if (isBonus) {
            return WinningRatingType.SECOND;
        }
        return WinningRatingType.THIRD;
    }

    public static Map<WinningRatingType, WinningCount> toWinningCount() {
        return Arrays.stream(values())
                .collect(Collectors.toMap(
                        typeKey -> typeKey,
                        value -> new WinningCount()
                ));
    }
}
