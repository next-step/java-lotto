package lotto.domain;

import java.util.Arrays;
import java.util.Set;

public enum LottoRule {
    FIRST(6, 2_000_000_000, 1),
    SECOND(5, true, 30_000_000, 2),
    THIRD(5, false, 1_500_000, 3),
    FOURTH(4, 50_000, 4),
    FIFTH(3, 5_000, 5),
    NONE(0, 0, 0);

    private final int matchCount;
    private final Set<Boolean> bonusBallMatchRule;
    private final int prize;
    private final int rank;

    LottoRule(final int matchCount, final int prize, final int rank) {
        this(matchCount, Set.of(false, true), prize, rank);
    }

    LottoRule(final int matchCount, final boolean isMatchBonus, final int prize, final int rank) {
        this(matchCount, Set.of(isMatchBonus), prize, rank);
    }

    LottoRule(
            final int matchCount,
            final Set<Boolean> bonusBallMatchRule,
            final int prize,
            final int rank
    ) {
        this.matchCount = matchCount;
        this.bonusBallMatchRule = bonusBallMatchRule;
        this.prize = prize;
        this.rank = rank;
    }

    public static LottoResult winningResult(final int matchCount, final boolean isMatchBonus) {
        LottoRule rule = Arrays.stream(LottoRule.values())
                .filter(r -> r.isMatch(matchCount, isMatchBonus))
                .findAny()
                .orElse(NONE);

        return new LottoResult(rule);
    }

    private boolean isMatch(final int matchCount, final boolean isMatchBonus) {
        return this.matchCount == matchCount && this.bonusBallMatchRule.contains(isMatchBonus);
    }

    public int getRank() {
        return this.rank;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }
}
