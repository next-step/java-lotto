package lotto.domain;

import java.util.Arrays;

public enum PrizeRank {
    FIRST(2_000_000_000, new CountMatchRule(MatchCount.of(6))),
    SECOND(30_000_000, new CountAndBonusMatchRule(MatchCount.of(5), true)),
    THIRD(1_500_000, new CountAndBonusMatchRule(MatchCount.of(5), false)),
    FOURTH(50_000, new CountMatchRule(MatchCount.of(4))),
    FIFTH(5_000, new CountMatchRule(MatchCount.of(3))),
    NONE(0, new CountMatchRule(MatchCount.of(0)));

    private final int prize;
    private final PrizeRankRule rankRule;

    PrizeRank(int prize, PrizeRankRule rankRule) {
        this.prize = prize;
        this.rankRule = rankRule;
    }

    public int getMatchCount() {
        return rankRule.getMatchCount();
    }

    public int getPrize() {
        return prize;
    }

    public static PrizeRank of(MatchCount matchCount, boolean bonus) {
        return Arrays.stream(values()).filter(rank -> rank.rankRule.matches(matchCount, bonus)).findFirst().orElse(NONE);
    }
}
