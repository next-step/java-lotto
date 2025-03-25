package lotto.domain.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int matchCriteria;
    private final int winningPrize;

    Rank(final int matchCriteria, final int winningPrize) {
        this.matchCriteria = matchCriteria;
        this.winningPrize = winningPrize;
    }

    public int getMatchCriteria() {
        return matchCriteria;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public static Rank of(int matchCount) {
        return Arrays.stream(values())
                .filter(r -> r.getMatchCriteria() == matchCount)
                .findFirst()
                .orElse(MISS);
    }
}
