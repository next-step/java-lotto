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

    public Profit calculateTotalProfit() {
        Profit totalProfit = new Profit();

        for (MatchCount matchCount : pair.keySet()) {
            Integer count = pair.get(matchCount);
            Rank rank = Rank.valueOf(matchCount);
            totalProfit.add(calculateProfit(count, rank));
        }

        return totalProfit;
    }

    private int calculateProfit(Integer count, Rank rank) {
        return count * rank.profit();
    }

    private int addMatchCount(Map<MatchCount, Integer> matchCountPairs, MatchCount matchCount) {
        return matchCountPairs.getOrDefault(matchCount, DEFAULT_MATCH_COUNT) + MATCH_COUNT;
    }

    public Integer countByMatchCount(MatchCount index) {
        return pair.get(index);
    }
}
