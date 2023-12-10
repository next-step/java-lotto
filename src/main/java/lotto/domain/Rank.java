package lotto.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),

    FIFTH(3, 5_000);


    private final int matchCount;
    private final long prizeAmount;

    Rank(int matchCount, long prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
    }

    public int matchCount() {
        return this.matchCount;
    }

    public long prizeAmount() {
        return this.prizeAmount;
    }

    public static Optional<Rank> valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 5 && matchBonus) {
            return Optional.of(Rank.SECOND);
        }

        return Arrays.stream(Rank.values())
            .filter(r -> r.matchCount == countOfMatch)
            .findFirst();
    }


    public static Rank rankByMatchCount(int matchCount) {
        if (matchCount == 6) {
            return Rank.FIRST;
        }

        if (matchCount == 5) {
            return Rank.SECOND;
        }

        if (matchCount == 4) {
            return Rank.THIRD;
        }

        if (matchCount == 3) {
            return Rank.FOURTH;
        }

        throw new IllegalArgumentException();
    }
}
