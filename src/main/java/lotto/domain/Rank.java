package lotto.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, new Money(2_000_000_000L)),
    SECOND(5, new Money(30_000_000L)),
    THIRD(5, new Money(1_500_000L)),
    FOURTH(4, new Money(50_000L)),
    FIFTH(3, new Money(5_000L)),
    MISS(0, new Money(0L));

    private final int count;
    private final Money money;
    private static final Map<Long, Rank> RANK_CACHE;

    static {
        RANK_CACHE = new HashMap<>();
        RANK_CACHE.put(6L, Rank.FIRST);
        RANK_CACHE.put(5L, Rank.THIRD);
        RANK_CACHE.put(4L, Rank.FOURTH);
        RANK_CACHE.put(3L, Rank.FIFTH);
        RANK_CACHE.put(0L, Rank.MISS);
    }

    Rank(int count, Money money) {
        this.count = count;
        this.money = money;
    }

    public static Rank of(long count, boolean hasBonus) {
        if (count == SECOND.count && hasBonus) {
            return SECOND;
        }
        return Optional.ofNullable(RANK_CACHE.get(count)).orElse(Rank.MISS);
    }

    public Money getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }
}
