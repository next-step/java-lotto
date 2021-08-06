package step3;

import java.util.Optional;
import java.util.stream.Stream;

public enum LottoWin {
    SIX_MATCH(2000000000, 6, false),
    FIVE_WITH_BONUS_MATCH(30000000, 5, true),
    FIVE_MATCH(1500000, 5, false),
    FOUR_MATCH(50000, 4, false),
    THREE_MATCH(5000, 3, false),
    NONE_MATCH(0, 0, false);

    private final int prize;
    private final int matchCount;
    private final boolean bonusMatch;

    LottoWin(int winPrize, int matchCount, boolean bonusMatch) {
        this.prize = winPrize;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public static LottoWin getMatchResult(DrawnLotto drawnLotto, LottoEntry lottoEntry) {
        int match = drawnLotto.countMatch(lottoEntry);
        boolean bonus = drawnLotto.bonus(lottoEntry);

        return fromMatch(match, bonus).orElse(NONE_MATCH);
    }

    public static Optional<LottoWin> fromMatch(int match, boolean bonus) {
        return Stream.of(values())
                .filter(w -> matched(match, bonus, w))
                .findFirst();
    }

    private static boolean matched(int match, boolean bonus, LottoWin w) {
        return w.matchCount == match && (w.bonusMatch == bonus);
    }

    public int prize() {
        return this.prize;
    }

    public int matchCount() {
        return this.matchCount;
    }

    public boolean bonusMatch() {
        return this.bonusMatch;
    }
}
