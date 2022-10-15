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
            .filter(rank -> ranking(matchCount == 5, checkBonusBall(hasBonusBall, rank), rank.matchCount == matchCount))
            .findFirst()
            .orElse(LOSER);
    }

    private static boolean ranking(boolean matchCount, boolean hasBonusBall, boolean matchCount1) {
        if (matchCount) {
            return hasBonusBall;
        }
        return matchCount1;
    }

    private static boolean checkBonusBall(boolean hasBonusBall, Rank rank) {
        return ranking(hasBonusBall, rank == SECOND, rank == THIRD);
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
