package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Matches {
    private final List<Integer> countMatches;

    public Matches(final List<Integer> countMatches) {
        this.countMatches = countMatches;
    }

    public Winning winning(final int matchCount) {
        int winningCount = (int) countMatches.stream()
                .filter(match -> matchCount == match)
                .count();
        return new Winning(matchCount, winningCount);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Matches matches = (Matches) o;
        return Objects.equals(countMatches, matches.countMatches);
    }
}
