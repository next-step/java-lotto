package lotto.domain;

import java.util.Collections;
import java.util.List;

public class MatchingResult {

    private List<Integer> matchingNumbers;

    public MatchingResult(List<Integer> matchingNumbers) {
        this.matchingNumbers = Collections.unmodifiableList(matchingNumbers);
    }

    public int matchingNumberCount() {
        return this.matchingNumbers.size();
    }

    @Override
    public String toString() {
        return "MatchingResult{" +
                "matchingNumbers=" + matchingNumbers +
                '}';
    }
}
