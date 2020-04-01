package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Winning {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000),
    LOSE(0, 0);

    private int matchCount;
    private int winningPrice;

    private static Map<Integer, Winning> winningTypes;

    static {
        winningTypes = new HashMap<>();

        for (Winning winning : Winning.values()) {
            winningTypes.put(winning.getMatchCount(), winning);
        }
    }

    public static List<Winning> winValues() {
        return Arrays.stream(values()).filter(winning -> winning != LOSE).collect(Collectors.toList());
    }

    public static Winning getWinningType(int matchCount) {
        if (matchCount < 3) {
            return LOSE;
        }

        return winningTypes.get(matchCount);
    }

    Winning(int matchCount, int winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
