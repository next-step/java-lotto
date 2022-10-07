package lotto.domain;

import java.util.EnumMap;
import java.util.stream.Stream;

public enum Rank {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    LOSER(0, 0);

    private final int reward;
    private final int matchCount;
    Rank(int reward, int matchCount) {
        this.reward = reward;
        this.matchCount = matchCount;
    }

    static Rank valueOf(int matchCount) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5) {
            return SECOND;
        }
        if (matchCount == 4) {
            return THIRD;
        }
        if (matchCount == 3) {
            return FOURTH;
        }
        return LOSER;
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
            Rank.LOSER
        );
    }
}
