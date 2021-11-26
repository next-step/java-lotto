package lotto.domain;

import java.util.Arrays;
import java.util.function.Supplier;

public enum Rank implements Supplier<Rank> {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private long count;
    private long prizeMoney;

    Rank(long count, long prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public boolean isPrizeMoney() {
        return this.getPrizeMoney() > 0;
    }

    public static Rank valueOf(long countOfMatch, boolean matchBonus) {
        Rank result = Arrays.stream(values())
            .filter(rank -> rank.count == countOfMatch)
            .findFirst()
            .orElseGet(NONE);

        if (isSecond(matchBonus, result)) {
            return Rank.SECOND;
        }

        return result;
    }

    private static boolean isSecond(boolean matchBonus, Rank result) {
        if (result.equals(Rank.THIRD) && matchBonus) {
            return true;
        }
        return false;
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
