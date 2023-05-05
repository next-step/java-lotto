package step2.domain;

import java.security.InvalidParameterException;
import java.util.Arrays;

public enum PrizeMoney {
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FORTH(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int rightCount;
    private long prizeMoney;

    PrizeMoney(int rightCount, long prizeMoney) {
        this.rightCount = rightCount;
        this.prizeMoney = prizeMoney;
    }

    public static long toPrizeMoney(int rightCount) {
        return Arrays.stream(values())
                .filter(prizeMoney -> prizeMoney.rightCount == rightCount)
                .findAny()
                .map(prizeMoney -> prizeMoney.prizeMoney)
                .orElseThrow(() -> new InvalidParameterException());
    }
}
