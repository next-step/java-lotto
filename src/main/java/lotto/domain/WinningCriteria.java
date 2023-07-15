package lotto.domain;

import java.util.Arrays;
import java.util.Set;

public enum WinningCriteria {
    FIRST(6, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final Set<Boolean> bonusResults;
    private final long prize;

    WinningCriteria(final int matchCount, final int prize) {
        this(matchCount, Set.of(false, true), prize);
    }

    WinningCriteria(final int matchCount, final boolean isMatchBonus, final int prize) {
        this(matchCount, Set.of(isMatchBonus), prize);
    }

    WinningCriteria(final int matchCount, final Set<Boolean> bonusResults, final int prize) {
        this.matchCount = matchCount;
        this.bonusResults = bonusResults;
        this.prize = prize;
    }

    public static WinningCriteria winningResult(final int matchCount, final boolean isMatchBonus) {
        return Arrays.stream(WinningCriteria.values())
                .filter(value -> value.matchCount == matchCount && value.bonusResults.contains(isMatchBonus))
                .findAny().orElse(NONE);
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public long getPrize() {
        return this.prize;
    }
}
