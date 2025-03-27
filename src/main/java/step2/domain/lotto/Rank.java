package step2.domain.lotto;

import step2.domain.MatchedCount;

import java.util.EnumSet;

public enum Rank {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000),
    NO_RANK(0, 0);

    private final int requiredMatches;
    private final long winnings;

    Rank(int requiredMatches, long winnings) {
        this.requiredMatches = requiredMatches;
        this.winnings = winnings;
    }

    public boolean matches(MatchedCount matchedCount) {
        RankMatcher rankMatcher = new RankMatcher(requiredMatches);
        return rankMatcher.matches(matchedCount);
    }

    public long getTotalWinnings(int count) {
        return winnings * count;
    }

    public String displayRank() {
        return String.format("%d개 일치 (%d)원", requiredMatches, winnings);
    }

    public static Rank[] validValues() {
        return EnumSet.complementOf(EnumSet.of(NO_RANK)).toArray(new Rank[0]);
    }

}
