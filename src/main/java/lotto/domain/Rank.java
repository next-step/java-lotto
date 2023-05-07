package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public enum Rank {
    FIFTH_GRADE(Match.of(3, false), 5_000),
    FOURTH_GRADE(Match.of(4, false), 50_000),
    THIRD_GRADE(Match.of(5, false), 1_500_000),
    SECOND_GRADE(Match.of(5, true), 30_000_000),
    FIRST_GRADE(Match.of(6, false), 2_000_000_000);

    public static class Match {

        private final int matchCount;
        private final boolean bonusMatch;

        private Match(int matchCount, boolean bonusMatch) {
            this.matchCount = matchCount;
            this.bonusMatch = bonusMatch;
        }

        public static Match of(int matchCount, boolean bonusMatch) {
            return new Match(matchCount, bonusMatch);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Match match = (Match) o;
            return matchCount == match.matchCount && bonusMatch == match.bonusMatch;
        }

        @Override
        public int hashCode() {
            return Objects.hash(matchCount, bonusMatch);
        }

    }

    private final Match match;

    private final int amount;

    Rank(Match match, int amount) {
        this.match = match;
        this.amount = amount;
    }

    public int matchCount() {
        return match.matchCount;
    }

    public int amount() {
        return amount;
    }

    public boolean isBonusMatchCount(int count) {
        return match.bonusMatch && match.matchCount == count;
    }

    public boolean isBonusRank() {
        return match.bonusMatch;
    }

    public static boolean isNotWinning(int winningCount, boolean isBonusMatch) {
        return of(winningCount, isBonusMatch).isEmpty();
    }

    public static Optional<Rank> of(int winningCount, boolean isBonusMatch) {
        return Arrays.stream(values())
            .filter(rank -> rank.match.equals(Match.of(winningCount, isBonusMatch)))
            .findFirst();
    }

}
