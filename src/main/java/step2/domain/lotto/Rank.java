package step2.domain.lotto;

import step2.domain.MatchedCount;

public enum Rank {
    FIRST("1등", 6, 2000000000),
    SECOND("2등", 5, 1500000),
    THIRD("3등", 4, 50000),
    FOURTH("4등", 3, 5000),
    NO_RANK("당첨없음", 0, 0);

    private final String title;
    private final int requiredMatches;
    private final int winnings;

    Rank(String title, int requiredMatches, int winnings) {
        this.title = title;
        this.requiredMatches = requiredMatches;
        this.winnings = winnings;
    }

    public boolean matches(MatchedCount matchedCount) {
        RankMatcher rankMatcher = new RankMatcher(requiredMatches);
        return rankMatcher.matches(matchedCount);
    }

    public int getTotalWinnings(int count) {
        return winnings * count;
    }

    public String displayRank() {
        return String.format("%d개 일치 (%d)원", requiredMatches, winnings);
    }
}
