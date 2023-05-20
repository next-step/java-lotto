package lotto.domain.result;

import java.util.Arrays;
import java.util.stream.IntStream;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0)
    ;

    private int matchingCount;
    private int prize;

    Rank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank find(MatchCount matchCount, boolean isBonusBall) {
        return Arrays.stream(values())
                .filter(rank -> support(rank, matchCount, isBonusBall))
                .findFirst()
                .orElse(Rank.MISS);
    }

    private static boolean support(Rank rank, MatchCount matchCount, boolean isBonusBall) {
        if (rank == Rank.FIRST) {
            return matchCount.value() == 6;
        }

        if (rank == Rank.SECOND) {
            return matchCount.value() == 5 && isBonusBall;
        }

        if (rank == Rank.THIRD) {
            return matchCount.value() == 5 && !isBonusBall;
        }

        if (rank == Rank.FOURTH) {
            return matchCount.value() == 4;
        }

        if (rank == Rank.FIFTH) {
            return matchCount.value() == 3;
        }

        return false;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

}
