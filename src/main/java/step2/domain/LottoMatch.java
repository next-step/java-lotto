package step2.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoMatch {
    NONE(0, 0),

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final long number;
    private final long winningReward;

    LottoMatch(final long number, final long winningReward) {
        this.number = number;
        this.winningReward = winningReward;
    }

    public static LottoMatch of(final long count) {
        if (count == 3) {
            return THREE;
        }
        if (count == 4) {
            return FOUR;
        }
        if (count == 5) {
            return FIVE;
        }
        if (count == 6) {
            return SIX;
        }
        return NONE;
    }

    public long winningReward() {
        return winningReward;
    }

    public static List<LottoMatch> all() {
        return Arrays.asList(THREE, FOUR, FIVE, SIX);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
