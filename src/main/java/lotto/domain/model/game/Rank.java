package lotto.domain.model.game;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5,  1_500_000),
    FOURTH(4,  50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCriteria;
    private final int winningPrize;
    private Boolean isBonusMatch;

    Rank(final int matchCriteria, final int winningPrize) {
        this.matchCriteria = matchCriteria;
        this.winningPrize = winningPrize;
    }

    Rank(final int matchCriteria, final Boolean isBonusMatch, final int winningPrize) {
        this(matchCriteria, winningPrize);
        this.isBonusMatch = isBonusMatch;
    }

    public int getMatchCriteria() {
        return matchCriteria;
    }

    public Boolean isBonusMatch() {
        return isBonusMatch;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public static Rank of(final int matchCount, final boolean isBonusMatch) {
        return Arrays.stream(values())
                .filter(r -> r.getMatchCriteria() == matchCount)
                .filter(r -> r.isBonusMatch() == null || r.isBonusMatch().equals(isBonusMatch))
                .findFirst()
                .orElse(MISS);
    }

}
