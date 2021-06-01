package lottery.domain;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

import static lottery.domain.WinnerLottery.DEFAULT_MATCH_COUNT;
import static lottery.domain.WinnerLottery.MATCH_COUNT;

public class MatchCountPair {

    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;

    private ImmutableMap<Integer, Integer> pair;

    public MatchCountPair() {
        this.pair = ImmutableMap.copyOf(initializeMatchCountPairs());
    }

    private Map<Integer, Integer> initializeMatchCountPairs() {
        Map<Integer, Integer> matchCountPairs = new HashMap<>();

        matchCountPairs.put(THREE_MATCH, DEFAULT_MATCH_COUNT);
        matchCountPairs.put(FOUR_MATCH, DEFAULT_MATCH_COUNT);
        matchCountPairs.put(FIVE_MATCH, DEFAULT_MATCH_COUNT);
        matchCountPairs.put(SIX_MATCH, DEFAULT_MATCH_COUNT);

        return matchCountPairs;
    }

    void addMatchCountPair(int matchCount) {
        Map<Integer, Integer> newPair = new HashMap<>(pair);
        newPair.put(matchCount, addMatchCount(pair, matchCount));
        pair = ImmutableMap.copyOf(newPair);
    }

    private int addMatchCount(Map<Integer, Integer> matchCountPairs, int matchCount) {
        return matchCountPairs.getOrDefault(matchCount, DEFAULT_MATCH_COUNT) + MATCH_COUNT;
    }

    public Integer get(int index) {
        return pair.get(index);
    }
}
