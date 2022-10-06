package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeService {
    public Map<Integer, Integer> confirmRank(List<Lotto> lottos, List<Integer> winningNumber) {
        Map<Integer, Integer> rankMap = initRankMap();

        for (Lotto lotto : lottos) {
            int matchingCount = lotto.findMatchingCount(winningNumber);
            addRankMap(rankMap, matchingCount);
        }
        return rankMap;
    }

    private Map<Integer, Integer> initRankMap() {
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (Prize value : Prize.values()) {
            rankMap.put(value.getWinningCount(), 0);
        }
        return rankMap;
    }

    private void addRankMap(Map<Integer, Integer> rankMap, int matchingCount) {
        if (matchingCount < Prize.RANK_4TH.getWinningCount()) {
            return;
        }
        rankMap.put(matchingCount, rankMap.get(matchingCount) + 1);
    }
}
