package lotto.domain;

import java.util.Arrays;

public enum Match {
    NONE(0, false, 0),
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int count;
    private final boolean hasBonusNumber;
    private final long prize;

    Match(int count, boolean hasBonusNumber, long prize) {
        this.count = count;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static Match of(int count, boolean hasBonusNumber) {
        Match match = Arrays.stream(values())
                .filter(value -> value.count == count)
                .findFirst()
                .orElse(NONE);
        if (match == FIVE && hasBonusNumber) {
            return FIVE_BONUS;
        }
        return match;
    }

    public long getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
