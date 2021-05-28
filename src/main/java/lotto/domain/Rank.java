package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    MISS(0, 0, 0);

    private int matchCount;
    private int matchBonusCount;
    private int prize;

    Rank(int countOfMatch, int matchBonusCount, int prize) {
        this.matchCount = countOfMatch;
        this.matchBonusCount = matchBonusCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMatchBonusCount() {
        return matchBonusCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank valueOf(int matchCount, int matchBonusCount) {
        Optional<Rank> result = Arrays.stream(values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .filter(rank -> rank.getMatchBonusCount() == matchBonusCount)
                .findFirst();

        return result.orElseGet(() -> Rank.MISS);
    }
}
