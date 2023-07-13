package lotto.domain;

import java.util.Arrays;
import java.util.Set;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final Set<Boolean> bonusBallMatchRule;
    private final int prize;

    LottoRank(final int matchCount, final int prize) {
        this(matchCount, Set.of(false, true), prize);
    }

    LottoRank(final int matchCount, final boolean isMatchBonus, final int prize) {
        this(matchCount, Set.of(isMatchBonus), prize);
    }

    LottoRank(
            final int matchCount,
            final Set<Boolean> bonusBallMatchRule,
            final int prize
    ) {
        this.matchCount = matchCount;
        this.bonusBallMatchRule = bonusBallMatchRule;
        this.prize = prize;
    }

    public static LottoRank winningResult(final int matchCount, final boolean isMatchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(r -> r.isMatch(matchCount, isMatchBonus))
                .findAny()
                .orElse(NONE);
    }

    private boolean isMatch(final int matchCount, final boolean isMatchBonus) {
        return this.matchCount == matchCount && this.bonusBallMatchRule.contains(isMatchBonus);
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }
}
