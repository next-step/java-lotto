package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public enum Winning {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    LOSE(0, 0);

    private static final int MIN_WINNING_CONDITION = 3;

    private static Map<Integer, Winning> winningTypes;

    private int matchCount;
    private int winningPrice;

    static {
        winningTypes = new LinkedHashMap<>();

        for (Winning winning : Winning.values()) {
            winningTypes.put(winning.getMatchCount(), winning);
        }
    }

    Winning(int matchCount, int winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public static List<Winning> winValues() {
        return Arrays.stream(values())
                .filter(winning -> winning != LOSE)
                .collect(Collectors.toList());
    }

    public static Winning getWinningType(int matchCount) {
        if (matchCount < MIN_WINNING_CONDITION) {
            return LOSE;
        }

        return winningTypes.get(matchCount);
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
