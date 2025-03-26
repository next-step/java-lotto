package domain.lotto;

import domain.MatchedCount;

public enum Rank {
    FIRST("1등", new RankMatcher(6)),
    SECOND("2등", new RankMatcher(5)),
    THIRD("3등", new RankMatcher(4)),
    FOURTH("4등", new RankMatcher(3)),
    NO_RANK("당첨없음", new RankMatcher(0));

    private final String title;
    private final RankMatcher rankMatcher;

    Rank(String title, RankMatcher rankMatcher) {
        this.title = title;
        this.rankMatcher = rankMatcher;
    }

    public String getTitle() {
        return title;
    }

    public boolean matches(MatchedCount matchedCount) {
        return rankMatcher.matches(matchedCount);
    }
}
