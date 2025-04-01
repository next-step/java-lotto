package step2.domain.rank;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.WinningLotto;
import step2.domain.rank.rankmatcher.GeneralRankMatcher;
import step2.domain.rank.rankmatcher.SecondRankMatcher;

import java.util.EnumSet;

public enum RankType {
    FIFTH(3, new GeneralRankMatcher(3), 5_000),
    FOURTH(4, new GeneralRankMatcher(4), 50_000),
    THIRD(5, new GeneralRankMatcher(5), 1_500_000),
    SECOND(5, new SecondRankMatcher(), 30_000_000),
    FIRST(6, new GeneralRankMatcher(6), 2_000_000_000),
    NO_RANK(0, new GeneralRankMatcher(0), 0);

    private final int requiredMatches;
    private final RankMatcher rankMatcher;
    private final long winnings;

    RankType(int requiredMatches, RankMatcher rankMatcher, long winnings) {
        this.requiredMatches = requiredMatches;
        this.rankMatcher = rankMatcher;
        this.winnings = winnings;
    }

    public boolean matches(WinningLotto winningLotto, Lotto lotto) {
        return rankMatcher.matches(winningLotto, lotto);
    }

    public long getTotalWinnings(int count) {
        return winnings * count;
    }

    public static RankType[] validValues() {
        return EnumSet.complementOf(EnumSet.of(NO_RANK)).toArray(new RankType[0]);
    }

    public int getRequiredMatches() {
        return requiredMatches;
    }

    public long getWinnings() {
        return winnings;
    }

    public String getAdditionalDescription() {
        return rankMatcher.getAdditionalDescription();
    }
}
