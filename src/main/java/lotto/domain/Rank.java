package lotto.domain;

import java.util.Arrays;
import java.util.function.Supplier;

public enum Rank implements Supplier<Rank> {
    FOURTH(3, 5_000)
    , THIRD(4, 50_000)
    , SECOND(5, 1_500_000)
    , FIRST(6, 2_000_000_000)
    , NONE(0, 0);

    private long count;
    private long money;

    Rank(long count, long money) {
        this.count = count;
        this.money = money;
    }

    public long getCount() {
        return count;
    }

    public long getMoney() {
        return money;
    }

    public static Rank equalToCount(Long count) {
        return Arrays.stream(values())
            .filter(rank -> rank.count == count)
            .findFirst()
            .orElseGet(NONE);
    }

    @Override
    public Rank get() {
        return this;
    }
}
