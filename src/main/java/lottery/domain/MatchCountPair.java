package lottery.domain;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

import static lottery.domain.WinnerLottery.DEFAULT_MATCH_COUNT;
import static lottery.domain.WinnerLottery.MATCH_COUNT;

public class MatchCountPair {

    public static final int MINIMUM_JACKPOT = 0;

    private final ImmutableMap<Rank, Integer> pair;

    public MatchCountPair(WinnerLottery winnerLottery, ImmutableList<LotteryNumbers> lotteries, int bonusBall) {
        this.pair = matchAllAndAddCounts(winnerLottery, lotteries, bonusBall);
    }

    private ImmutableMap<Rank, Integer> matchAllAndAddCounts(
            WinnerLottery winnerLottery,
            ImmutableList<LotteryNumbers> lotteries,
            int bonusBall
    ) {
        Map<Rank, Integer> pair = initializeMatchCountPairs();

        for (LotteryNumbers lottery : lotteries) {
            boolean matchBonus = lottery.contains(new LotteryNumber(bonusBall));
            Rank rank = findMatchCount(winnerLottery, lottery, matchBonus);
            pair.put(rank, addMatchCount(pair, rank));
        }

        return ImmutableMap.copyOf(pair);
    }

    private Rank findMatchCount(WinnerLottery winnerLottery, LotteryNumbers lottery, boolean matchBonus) {
        return Rank.valueOf(winnerLottery.match(lottery), matchBonus);
    }

    private Map<Rank, Integer> initializeMatchCountPairs() {
        Map<Rank, Integer> matchCountPairs = new HashMap<>();

        for (Rank rank : Rank.values()) {
            matchCountPairs.put(rank, DEFAULT_MATCH_COUNT);
        }

        return matchCountPairs;
    }

    public int calculateTotalJackpot() {
        int totalProfit = MINIMUM_JACKPOT;

        for (Rank rank : pair.keySet()) {
            int profit = calculateJackpot(pair.get(rank), rank);
            totalProfit += profit;
        }

        return totalProfit;
    }

    private int calculateJackpot(Integer count, Rank rank) {
        return count * rank.profit();
    }

    private int addMatchCount(Map<Rank, Integer> matchCountPairs, Rank rank) {
        return matchCountPairs.getOrDefault(rank, DEFAULT_MATCH_COUNT) + MATCH_COUNT;
    }

    public Integer countByRank(Rank rank) {
        return pair.get(rank);
    }
}
