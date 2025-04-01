package step3.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000,
            matchCondition -> matchCondition.matchCount() == 6),
    SECOND(5, 30_000_000,
            matchCondition -> matchCondition.matchCount() == 5 && matchCondition.matchBonus()),
    THIRD(5, 1_500_000,
            matchCondition -> matchCondition.matchCount() == 5 && !matchCondition.matchBonus()),
    FOURTH(4, 50_000,
            matchCondition -> matchCondition.matchCount() == 4),
    FIFTH(3, 5_000,
            matchCondition -> matchCondition.matchCount() == 3),
    MISS(0, 0,
            matchCondition -> true);


    private final int matchCount;
    private final int winningMoney;
    private final RankMatcher rankMatcher;

    Rank(int matchCount, int winningMoney, RankMatcher rankMatcher) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.rankMatcher = rankMatcher;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        MatchCondition matchCondition = new MatchCondition(matchCount, matchBonus);
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.rankMatcher.matches(matchCondition))
                .findFirst()
                .orElse(MISS);
    }
}
