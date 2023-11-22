package lotto;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoMatch {
    ZERO(Match.ZERO, 0),
    ONE(Match.ONE, 0),
    TWO(Match.TWO, 0),
    THREE(Match.THREE, 5000),
    FOUR(Match.FOUR, 50000),
    FIVE(Match.FIVE, 1500000),
    FIVE_BONUS(Match.FIVE_BONUS, 30000000),
    SIX(Match.SIX, 2000000000);

    public enum Match {
        ZERO(0, false),
        ONE(1, false),
        TWO(2, false),
        THREE(3, false),
        FOUR(4, false),
        FIVE(5, false),
        FIVE_BONUS(5, true),
        SIX(6, false);

        private final int matchCount;

        private final boolean isBonus;

        Match(int matchCount, boolean isBonus) {
            this.matchCount = matchCount;
            this.isBonus = isBonus;
        }

        public static Match from(int matchCount, boolean isBonus) {
            return Arrays.stream(values())
                    .filter(match -> match.matchCount == matchCount && match.isBonus == isBonus)
                    .findAny()
                    .orElse(Match.ZERO);
        }
    }

    private final Match match;

    private final long amount;

    LottoMatch(Match match, long amount) {
        this.match = match;
        this.amount = amount;
    }

    private static final Map<Match, LottoMatch> MATCH_TO_ENUM =
            Stream.of(values()).collect(Collectors.toMap(LottoMatch::match, e -> e));

    public static LottoMatch fromMatch(Match match) {
        return MATCH_TO_ENUM.get(match);
    }

    public static int matchesCount(Match match, LottoMatchResult lottoMatchResult) {
        long matchedCount =
                lottoMatchResult.lottoMatches()
                        .stream()
                        .filter(lottoMatch -> lottoMatch.match == match)
                        .count();

        return (int) matchedCount;
    }

    public Match match() {
        return this.match;
    }

    public int matchCount() {
        return this.match.matchCount;
    }

    public boolean isBonus() {
        return this.match.isBonus;
    }

    public long amount() {
        return this.amount;
    }
}
