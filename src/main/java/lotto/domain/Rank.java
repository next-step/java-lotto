package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int prize;

    Rank(int countOfMatch, int prize) {
        this.matchCount = countOfMatch;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank valueOf(int matchCount) {
        Optional<Rank> result = Arrays.stream(values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst();

        return result.orElseGet(() -> Rank.MISS);
    }
}
