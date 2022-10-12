package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MatchingResult {

    private List<Integer> matchingNumbers;
    private int matchingCount;
    private boolean includeBonusNumber;

    public MatchingResult(List<Integer> matchingNumbers) {
        this.matchingNumbers = Collections.unmodifiableList(matchingNumbers);
    }

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

    public int matchingNumberCount() {
        return this.matchingNumbers.size();
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

}
