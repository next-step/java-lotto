package lotto.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public enum WinningType {
    HIT_COUNT_0(0, 0),
    HIT_COUNT_1(1, 0),
    HIT_COUNT_2(2, 0),
    HIT_COUNT_3(3, 5000L),
    HIT_COUNT_4(4, 50000L),
    HIT_COUNT_5(5, 1500000L),
    HIT_COUNT_6(6, 2000000000L);

    private final long hitCount;
    private final long revenue;

    public long getHitCount() {
        return hitCount;
    }

    public long getRevenue() {
        return revenue;
    }
    WinningType(long hitCount, long revenue) {
        this.hitCount = hitCount;
        this.revenue = revenue;
    }


    public static WinningType findByHitCount(long hitCount) {
        return Arrays.stream(WinningType.values())
                .filter(it -> Objects.equals(it.hitCount, hitCount))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
