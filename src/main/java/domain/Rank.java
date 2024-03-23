package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private static final Map<Pair, Rank> SIZE_TO_RANK;

    static {
        SIZE_TO_RANK = new HashMap<>();
        for (Rank rank : values()) {
            SIZE_TO_RANK.put(new Pair(rank.matchingNumber, rank.isMatchBonusNumber), rank);
        }
    }

    private final int matchingNumber;
    private final boolean isMatchBonusNumber;
    private final int amount;

    Rank(int matchingNumber, int amount) {
        this(matchingNumber, false, amount);
    }

    Rank(int matchingNumber, boolean isMatchBonusNumber, int amount) {
        this.matchingNumber = matchingNumber;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.amount = amount;
    }

    public static Rank of(int matchingNumber) {
        return of(matchingNumber, false);
    }

    public static Rank of(int matchNumber, boolean isMatchBonusNumber) {
        return SIZE_TO_RANK.getOrDefault(new Pair(matchNumber, isMatchBonusNumber), Rank.NONE);
    }

    public int prizeMoney(int count) {
        return this.amount * count;
    }

    private static class Pair {

        private final int matchNumber;
        private final boolean isMatchBonusNumber;

        public Pair(int matchNumber, boolean isMatchBonusNumber) {
            this.matchNumber = matchNumber;
            this.isMatchBonusNumber = isMatchBonusNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return matchNumber == pair.matchNumber && isMatchBonusNumber == pair.isMatchBonusNumber;
        }

        @Override
        public int hashCode() {
            return Objects.hash(matchNumber, isMatchBonusNumber);
        }
    }
}
