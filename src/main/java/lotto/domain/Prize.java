package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {

    first(6, 20_000_000),
    second(5, 1_500_000),
    third(4, 50_000),
    fouth(3, 5_000);

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

    public static Prize getMatchPrize(int matchCount) {
        Prize properPrize = Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchCount() == matchCount)
                .findFirst()
                .orElseThrow();

        return properPrize;
    }
}
