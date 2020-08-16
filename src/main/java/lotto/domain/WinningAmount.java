package lotto.domain;

import common.StringResources;

import java.util.Arrays;
import java.util.Optional;

public enum WinningAmount {

    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_6(6, 2000000000);

    private final int matchCount;
    private final int winningAmount;

    WinningAmount(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static WinningAmount of(int matchCount) {

        Optional<WinningAmount> maybe = Arrays.stream(values())
                .filter(w -> matchCount == w.matchCount)
                .findAny();

        if (!maybe.isPresent()) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_RANGE_RESULT_NUMBER);
        }

        return maybe.get();
    }

    public int getMoney() {
        return winningAmount;
    }
}
