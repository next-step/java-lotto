package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {

    first(6, 20000000),
    second(5, 1500000),
    third(4, 50000),
    fouth(3, 5000);

    private final int matchCount;
    private final int winningPrize;

    Prize(int matchCount, int winningPrize) {
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
