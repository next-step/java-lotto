package step2.domain;

import java.security.InvalidParameterException;
import java.util.Arrays;

public enum PrizeMoney {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FORTH(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int matchCount;
    private long prizeMoney;

    PrizeMoney(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static PrizeMoney toPrizeMoney(int matchCount) {
        return Arrays.stream(values())
                .filter(prizeMoney -> prizeMoney.matchCount == matchCount)
                .findAny()
                .orElseThrow(() -> new InvalidParameterException());
    }

    public int matchCount() {
        return matchCount;
    }

    public long prizeMoney() {
        return prizeMoney;
    }
}
