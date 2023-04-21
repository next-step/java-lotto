package lotto.domain.rating;

import java.util.Arrays;

public enum WinningRatingType {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    LOST(0);

    WinningRatingType(int count) {
        this.count = count;
    }

    private final int count;

    public static WinningRatingType findBy(int count) {
        return Arrays.stream(values())
                .filter(value -> value.count == count)
                .findFirst()
                .orElseGet(() -> WinningRatingType.LOST);
    }
}
