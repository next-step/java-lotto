package lottery.domain;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

import static lottery.domain.WinnerLottery.DEFAULT_MATCH_COUNT;
import static lottery.domain.WinnerLottery.MATCH_COUNT;

public class MatchCountPair {

    private ImmutableMap<MatchCount, Integer> pair;

    public MatchCountPair() {
        this.pair = ImmutableMap.copyOf(initializeMatchCountPairs());
    }

    private Map<MatchCount, Integer> initializeMatchCountPairs() {
        Map<MatchCount, Integer> matchCountPairs = new HashMap<>();

        for (MatchCount matchCount : MatchCount.values()) {
            matchCountPairs.put(matchCount, DEFAULT_MATCH_COUNT);
        }

        return matchCountPairs;
    }

    void addMatchCountPair(MatchCount matchCount) {
        Map<MatchCount, Integer> newPair = new HashMap<>(pair);
        newPair.put(matchCount, addMatchCount(pair, matchCount));
        pair = ImmutableMap.copyOf(newPair);
    }

    private int addMatchCount(Map<MatchCount, Integer> matchCountPairs, MatchCount matchCount) {
        return matchCountPairs.getOrDefault(matchCount, DEFAULT_MATCH_COUNT) + MATCH_COUNT;
    }

    public Integer countByMatchCount(MatchCount index) {
        return pair.get(index);
    }
}
