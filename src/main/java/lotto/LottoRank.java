package lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0)
    ;

    private int matchCount;
    private int winningAmount;

    LottoRank(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static Set<Integer> getMatchCounts() {
        return Arrays.stream(values()).map(d -> d.matchCount).collect(Collectors.toSet());
    }

    public static boolean isWinning(int matchCount) {
        return getMatchCounts().contains(matchCount);
    }
}
