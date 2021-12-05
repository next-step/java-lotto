package edu.nextstep.camp.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(6, Prize.FIRST_PRIZE),
    SECOND(5, Prize.SECOND_PRIZE),
    THIRD(5, Prize.THIRD_PRIZE),
    FOURTH(4, Prize.FOURTH_PRIZE),
    FIFTH(3, Prize.FIFTH_PRIZE),
    NO_RANK(0, Prize.NO_PRIZE);

    private static final Map<Integer, Rank> rankMap = new HashMap<>();

    static {
        rankMap.put(6, FIRST);
        rankMap.put(5, THIRD);
        rankMap.put(4, FOURTH);
        rankMap.put(3, FIFTH);
    }

    private final int matchedCount;
    private final Prize prize;

    Rank(final int matchedCount, final Prize prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static Rank valueOf(final int rank, boolean bonusMatched) {
        if (rank < NO_RANK.matchedCount || rank > FIRST.matchedCount) {
            throw new IllegalArgumentException("invalid input: matched count must be 0 ~ 6.");
        }

        if (rank == FIRST.matchedCount && bonusMatched) {
            throw new IllegalArgumentException("invalid input: bonus cannot be matched with all of 6 numbers");
        }

        if (rank == SECOND.matchedCount && bonusMatched) {
            return SECOND;
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

    public Prize ofPrize(long counts) {
        return prize.multiply(counts);
    }
}
