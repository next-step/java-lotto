package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum WinningResult {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOUR(4, 50_000),
    FIVE(3, 5_000),
    NOTHING(0, 0);

    private final int matchingCount;
    private final int prizeAmount;

    WinningResult(int matchingCount, int prizeAmount) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
    }

    public static WinningResult getResult(int matchingCount, boolean matchingBonus) {
        WinningResult winningResult = Arrays.stream(values())
            .filter(result -> result.matchingCount == matchingCount)
            .findFirst()
            .orElse(NOTHING);
        if (winningResult == SECOND && !matchingBonus) {
            return THIRD;
        }
        return winningResult;
    }

    public static List<WinningResult> winningResults() {
        return Collections.unmodifiableList(Arrays.asList(FIVE, FOUR, THIRD, SECOND, FIRST));
    }

    public int count() {
        return matchingCount;
    }

    public int prize() {
        return prizeAmount;
    }
}
