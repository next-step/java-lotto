package lotto.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Predicate.*;

public enum Rank {
    FIRST(6, new Money(2_000_000_000L)),
    SECOND(5, new Money(30_000_000L)),
    THIRD(5, new Money(1_500_000L)),
    FOURTH(4, new Money(50_000L)),
    FIFTH(3, new Money(5_000L)),
    MISS(0, new Money(0L));

    private final long count;
    private final Money money;
    private static final Map<Long, Rank> RANK_CACHE = Arrays.stream(values())
            .filter(not(isEqual(Rank.SECOND)))
            .collect(Collectors.toMap(Rank::getCount, Function.identity()));

    Rank(int count, Money money) {
        this.count = count;
        this.money = money;
    }

    public static Rank of(long count, boolean hasBonus) {
        if (count == SECOND.count && hasBonus) {
            return SECOND;
        }
        return RANK_CACHE.getOrDefault(count, MISS);
    }

    public Money getMoney() {
        return money;
    }

    public long getCount() {
        return count;
    }
}
