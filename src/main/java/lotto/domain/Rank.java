package lotto.domain;

import java.util.EnumMap;
import java.util.stream.Stream;

public enum Rank {

    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    LOSER(0, 0);

    private final int reward;
    private final int matchCount;

    Rank(int reward, int matchCount) {
        this.reward = reward;
        this.matchCount = matchCount;
    }

    static Rank valueOf(int matchCount, boolean hasBonusBall) {
        return Rank.stream()
            .map(rank -> getRank(matchCount, hasBonusBall, rank))
            .findFirst()
            .orElse(LOSER);
    }

    private static Rank getRank(int matchCount, boolean hasBonusBall, Rank rank) {
        if (matchCount == 5 && hasBonusBall) {
            return SECOND;
        } else if (matchCount == 5) {
            return THIRD;
        } else {
            return rank;
        }
    }

    public int matchCount() {
        return matchCount;
    }

    static double yield(EnumMap<Rank, Integer> rankIntegerEnumMap, int purchaseMoney) {
        double sum = rankIntegerEnumMap.entrySet().stream()
            .mapToDouble(rankIntegerEntry -> rankIntegerEntry.getValue() * rankIntegerEntry.getKey().reward)
            .sum();
        return sum / purchaseMoney;
    }

    public int reward() {
        return reward;
    }

    static Stream<Rank> stream() {
        return Stream.of(
            Rank.FIRST,
            Rank.SECOND,
            Rank.THIRD,
            Rank.FOURTH,
            Rank.FIFTH,
            Rank.LOSER
        );
    }
}
