package lotto;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoMatch {
    NONE(Match.ZERO, 0),
    FIFTH(Match.THREE, 5000),
    FOURTH(Match.FOUR, 50000),
    THIRD(Match.FIVE, 1500000),
    SECOND(Match.FIVE_WITH_BONUS, 30000000),
    FIRST(Match.SIX, 2000000000);

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

    private Match match() {
        return this.match;
    }

    public int matchesCount(Match match, LottoMatchResult lottoMatchResult) {
        long count = lottoMatchResult.lottoMatches()
                .stream()
                .filter(lottoMatch -> lottoMatch == fromMatch(match))
                .count();

        return (int) count;
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

    public enum Match {
        ZERO(0, false),
        THREE(3, false),
        FOUR(4, false),
        FIVE(5, false),
        FIVE_WITH_BONUS(5, true),
        SIX(6, false);

        private final int matchCount;

        private final boolean isBonus;

        Match(int matchCount, boolean isBonus) {
            this.matchCount = matchCount;
            this.isBonus = isBonus;
        }

        static Match from(int matchCount, boolean isBonus) {
            if (matchCount == Match.FIVE_WITH_BONUS.matchCount && isBonus) {
                return FIVE_WITH_BONUS;
            }

            return Arrays.stream(values())
                    .filter(match -> match.matchCount == matchCount)
                    .findAny()
                    .orElse(Match.ZERO);
        }
    }
}
