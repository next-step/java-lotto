package lotto.model.gameresult;

import lotto.model.Rank;

import java.util.Collections;
import java.util.Map;

public class MatchingResult {
    private Map<Rank, Long> result;

    public MatchingResult(Map<Rank, Long> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public Long findMatchCount(Rank rank) {
        return result.get(rank);
    }
}