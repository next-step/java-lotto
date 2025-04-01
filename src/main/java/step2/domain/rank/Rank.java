package step2.domain.rank;

import views.RankFormatter;

import java.util.EnumSet;

public enum Rank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    NO_RANK(0, false, 0);

    private final int requiredMatches;
    private final boolean needsBonus;
    private final long winnings;

    Rank(int requiredMatches, boolean needsBonus, long winnings) {
        this.requiredMatches = requiredMatches;
        this.needsBonus = needsBonus;
        this.winnings = winnings;
    }

    public boolean matches(MatchedCount matchedCount, boolean hasBonus) {
        RankMatcher rankMatcher = new RankMatcher(requiredMatches);
        return rankMatcher.matches(matchedCount) && needsBonus == hasBonus;
    }

    public long getTotalWinnings(int count) {
        return winnings * count;
    }

    public RankFormatter generateFormatter() {
        return new RankFormatter(this.requiredMatches, this.winnings);
    }

    public static Rank[] validValues() {
        return EnumSet.complementOf(EnumSet.of(NO_RANK)).toArray(new Rank[0]);
    }

}
