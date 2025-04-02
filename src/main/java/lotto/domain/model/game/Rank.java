package lotto.domain.model.game;

import java.util.Arrays;

public enum Rank {

    FIRST(new MatchCount(6), new Prize(2_000_000_000)),
    SECOND(new MatchCount(5), BonusMatch.from(true), new Prize(30_000_000)),
    THIRD(new MatchCount(5), new Prize(1_500_000)),
    FOURTH(new MatchCount(4), new Prize(50_000)),
    FIFTH(new MatchCount(3), new Prize(5_000)),
    MISS(new MatchCount(0), Prize.zero());

    private final MatchCount matchCriteria;
    private final Prize winningPrize;
    private BonusMatch bonusMatch;

    Rank(final MatchCount matchCriteria, final Prize winningPrize) {
        this.matchCriteria = matchCriteria;
        this.winningPrize = winningPrize;
    }

    Rank(final MatchCount matchCriteria, final BonusMatch bonusMatch, final Prize winningPrize) {
        this(matchCriteria, winningPrize);
        this.bonusMatch = bonusMatch;
    }

    public MatchCount getMatchCriteria() {
        return matchCriteria;
    }

    public BonusMatch getBonusMatch() {
        return bonusMatch;
    }

    public Prize getWinningPrize() {
        return winningPrize;
    }

    public static Rank of(final MatchCount matchCount, final BonusMatch bonusMatch) {
        return Arrays.stream(values())
                .filter(r -> r.getMatchCriteria().equals(matchCount))
                .filter(r -> r.getBonusMatch() == null || r.getBonusMatch().equals(bonusMatch))
                .findFirst()
                .orElse(MISS);
    }

}
