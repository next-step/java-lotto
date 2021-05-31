package lottery.domain;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

import static lottery.domain.WinnerLottery.DEFAULT_MATCH_COUNT;
import static lottery.domain.WinnerLottery.MATCH_COUNT;

public class LotteryFactory {

    public static final int THREE_MATCH = 3;
    public static final int FOUR_MATCH = 4;
    public static final int FIVE_MATCH = 5;
    public static final int SIX_MATCH = 6;

    ImmutableMap<Integer, Integer> matchAll(Lotteries lotteries, WinnerLottery winnerLottery) {
        Map<Integer, Integer> matchCountPairs = matchAllAndAddCounts(lotteries, winnerLottery);
        return ImmutableMap.copyOf(matchCountPairs);
    }

    private Map<Integer, Integer> matchAllAndAddCounts(Lotteries lotteries, WinnerLottery winnerLottery) {
        Map<Integer, Integer> matchCountPairs = initializeMatchCountPairs();

        for (Lottery lottery : lotteries.lotteries()) {
            int matchCount = winnerLottery.match(lottery.numbers());
            matchCountPairs.put(matchCount, addMatchCount(matchCountPairs, matchCount));
        }

        return matchCountPairs;
    }

    private int addMatchCount(Map<Integer, Integer> matchCountPairs, int matchCount) {
        return matchCountPairs.getOrDefault(matchCount, DEFAULT_MATCH_COUNT) + MATCH_COUNT;
    }

    private Map<Integer, Integer> initializeMatchCountPairs() {
        Map<Integer, Integer> matchCountPairs = new HashMap<>();

        matchCountPairs.put(THREE_MATCH, DEFAULT_MATCH_COUNT);
        matchCountPairs.put(FOUR_MATCH, DEFAULT_MATCH_COUNT);
        matchCountPairs.put(FIVE_MATCH, DEFAULT_MATCH_COUNT);
        matchCountPairs.put(SIX_MATCH, DEFAULT_MATCH_COUNT);

        return matchCountPairs;
    }
}
