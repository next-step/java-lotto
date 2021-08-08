package step3.enums;

import step3.DrawnLotto;
import step3.LottoEntry;

import java.util.Optional;
import java.util.stream.Stream;

public enum Match {
    SIX_MATCH(2000000000, 6, false),
    FIVE_WITH_BONUS_MATCH(30000000, 5, true),
    FIVE_MATCH(1500000, 5, false),
    FOUR_MATCH(50000, 4, false),
    THREE_MATCH(5000, 3, false),
    NONE_MATCH(0, 0, false);

    private final int prize;
    private final int matchCount;
    private final boolean bonusMatch;

    Match(int winPrize, int matchCount, boolean bonusMatch) {
        this.prize = winPrize;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public static Match getMatchResult(DrawnLotto drawnLotto, LottoEntry lottoEntry) {
        int match = drawnLotto.countMatch(lottoEntry);
        boolean bonus = drawnLotto.bonus(lottoEntry);

        return fromMatch(match, bonus).orElse(NONE_MATCH);
    }

    public static Optional<Match> fromMatch(int match, boolean bonus) {
        return Stream.of(values())
                .filter(w -> w.matched(match, bonus))
                .findFirst();
    }

    private boolean matched(int matchCount, boolean bonusMatch) {
        return this.matchCount == matchCount && this.bonusMatch == bonusMatch;
    }

    public int prize() {
        return prize;
    }

    public int matchCount() {
        return matchCount;
    }

    public boolean bonusMatch() {
        return bonusMatch;
    }
}
