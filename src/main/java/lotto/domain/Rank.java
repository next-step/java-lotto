package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int matchedCount;
    private final int winningAmount;

    Rank(int matchedCount, int winningAmount) {
        this.matchedCount = matchedCount;
        this.winningAmount = winningAmount;
    }

    public int matchedCount() {
        return matchedCount;
    }

    public int winningAmount() {
        return winningAmount;
    }

    public static int winningAmount(int matchedCount) {
        if (getRank(matchedCount).isPresent()) {
            return getRank(matchedCount).get().winningAmount;
        }
        return 0;
    }

    private static Optional<Rank> getRank(int matchedCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchedCount == matchedCount)
                .findFirst();
    }

}