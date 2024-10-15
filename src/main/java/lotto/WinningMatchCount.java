package lotto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum WinningMatchCount {
    THREE(3), FOUR(4), FIVE(5), SIX(6);

    private int matchCount;

    WinningMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public static Set<Integer> getMatchCounts() {
        return Arrays.stream(values()).map(d -> d.matchCount).collect(Collectors.toSet());
    }

    public static boolean isWinning(int matchCount) {
        return getMatchCounts().contains(matchCount);
    }
}
