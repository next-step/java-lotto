package lotto.domain;

import java.util.Arrays;
import java.util.function.Supplier;

public enum Rank implements Supplier<Rank> {
    NONE(0, 0)
    , FOURTH(3, 5_000)
    , THIRD(4, 50_000)
    , SECOND(5, 1_500_000)
    , FIRST(6, 2_000_000_000);

    private long count;
    private long prizeMoney;

    Rank(long count, long prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public boolean isPrizeMoney() {
        return this.getPrizeMoney() > 0;
    }

    public static Rank equalToCount(long count) {
        return Arrays.stream(values())
            .filter(rank -> rank.count == count)
            .findFirst()
            .orElseGet(NONE);
    }

    public long calculatePrizeMoney(Integer count) {
        return this.prizeMoney * count;
    }

    public long getCount() {
        return count;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public Rank get() {
        return this;
    }
}
