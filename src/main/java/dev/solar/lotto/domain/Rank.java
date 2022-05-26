package dev.solar.lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int prizeMoney;
    private static final Rank[] ranks = values();

    Rank(final int countOfMatch, final int prizeMoney) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Rank rank(int countOfMatch, boolean matchBonus) {
        BiPredicate<Rank, Integer> filter = (x, y) -> x.countOfMatch == countOfMatch;

        final Rank rank = Arrays.stream(ranks)
                                .sorted(Comparator.comparing(Rank::getCountOfMatch).reversed())
                                .filter(value -> filter.test(value, countOfMatch))
                                .findAny()
                                .orElse(Rank.MISS);

        if (rank == Rank.SECOND && !matchBonus) {
            return Rank.THIRD;
        }
        return rank;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
