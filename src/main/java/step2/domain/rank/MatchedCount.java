package step2.domain.rank;

import java.util.Set;

public class MatchedCount {
    private final Set<Integer> matchedNumbersSet;

    public MatchedCount(Set<Integer> matchedNumbers) {
        this.matchedNumbersSet = matchedNumbers;
    }

    public boolean matchesCount(int number) {
        return matchedNumbersSet.size() == number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(matchedNumbersSet.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof MatchedCount))
            return false;

        MatchedCount other = (MatchedCount) obj;

        return matchedNumbersSet == other.matchedNumbersSet;
    }
}
