package lottery.domain;

import java.util.HashMap;
import java.util.Map;

public class LotteryFactory {

    static Map<Integer, Integer> matchAll(Lotteries lotteries, WinnerLottery winnerLottery) {
        Map<Integer, Integer> matchCountPairs = new HashMap<>();
        matchCountPairs.put(3, 0);
        matchCountPairs.put(4, 0);
        matchCountPairs.put(5, 0);
        matchCountPairs.put(6, 0);

        for (Lottery lottery : lotteries.lotteries()) {
            int matchCount = winnerLottery.match(lottery.numbers());
            matchCountPairs.put(matchCount, matchCountPairs.getOrDefault(matchCount, 0) + 1);
        }

        return matchCountPairs;
    }
}
