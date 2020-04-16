package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private static final int MIN_WINNING_CONDITION = 3;

    private static Map<Integer, Rank> rankTypes;

    private int matchCount;
    private int winningPrice;

    static {
        rankTypes = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            rankTypes.put(rank.getMatchCount(), rank);
        }
    }

    Rank(int matchCount, int winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public static List<Rank> winValues() {
        return Arrays.stream(values())
                .filter(rank -> rank != LOSE)
                .collect(Collectors.toList());
    }

    public static Rank getWinningType(int matchCount, boolean isBonusMatched) {
        if (matchCount < MIN_WINNING_CONDITION) {
            return LOSE;
        }

        if (matchCount == SECOND.matchCount && isBonusMatched) {
            return SECOND;
        }

        return rankTypes.get(matchCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int calculatePrice(int matchCount) {
        return matchCount * this.winningPrice;
    }
}
