package edu.nextstep.camp.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(6, Prize.FIRST_PRIZE),
    SECOND(5, Prize.SECOND_PRIZE),
    THIRD(4, Prize.THIRD_PRIZE),
    FOURTH(3, Prize.FOURTH_PRIZE),
    NO_RANK(0, Prize.NO_PRIZE);

    private static final Map<Integer, Rank> rankMap = new HashMap<>();

    static {
        rankMap.put(6, FIRST);
        rankMap.put(5, SECOND);
        rankMap.put(4, THIRD);
        rankMap.put(3, FOURTH);
    }

    private final int matchedCount;
    private final Prize prize;

    Rank(final int matchedCount, final Prize prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static Rank valueOf(final int rank) {
        if (rank < NO_RANK.matchedCount || rank > FIRST.matchedCount) {
            throw new IllegalArgumentException("invalid input: matched count must be 0 ~ 6.");
        }

        return rankMap.getOrDefault(rank, NO_RANK);
    }

    public Prize prize() {
        return prize;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "matchedCount=" + matchedCount +
                ", prize=" + prize +
                '}';
    }
}
