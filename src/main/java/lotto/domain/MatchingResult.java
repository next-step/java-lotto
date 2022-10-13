package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MatchingResult {
    private int matchingCount;
    private boolean includeBonusNumber;

    public MatchingResult(int matchingCount, boolean includeBonusNumber) {
        this.matchingCount = matchingCount;
        this.includeBonusNumber = includeBonusNumber;
    }

    public int getMatchingCount() {
        return this.matchingCount;
    }

    public boolean isIncludeBonusNumber() {
        return this.includeBonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchingResult that = (MatchingResult) o;
        return matchingCount == that.matchingCount && includeBonusNumber == that.includeBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchingCount, includeBonusNumber);
    }

    @Override
    public String toString() {
        return "MatchingResult{" +
                "matchingCount=" + matchingCount +
                ", includeBonusNumber=" + includeBonusNumber +
                '}';
    }
}
