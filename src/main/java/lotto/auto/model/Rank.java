package lotto.auto.model;

import java.util.Map;
import java.util.function.Function;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toMap;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    private static final Map<Integer, Rank> RANK = stream(Rank.values())
            .collect(toMap(Rank::getMatchCount, Function.identity()));

    private final int matchCount;
    private final int prizeMoney;

    Rank(final int matchCount, final int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static int findPrizeMoneyByMatchCount(final int matchCount) {
        validate(matchCount);
        return RANK.get(matchCount).getPrizeMoney();
    }

    private static void validate(final int matchCount) {
        if (!RANK.containsKey(matchCount)) {
            throw new IllegalArgumentException("key not found.");
        }
    }

    private int getMatchCount() {
        return matchCount;
    }

    private int getPrizeMoney() {
        return prizeMoney;
    }
}
