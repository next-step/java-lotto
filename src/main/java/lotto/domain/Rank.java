package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public enum Rank {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
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

        // 기능 구현
        return LOSE;
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
