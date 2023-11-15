package step2.domain;

import java.util.HashMap;
import java.util.Map;

import static step2.domain.WinningCount.findWinningCount;

public class LotteryWinningRank {

    private Map<WinningCount, Integer> winningCountMap;

    public LotteryWinningRank() {
        this.winningCountMap = new HashMap<>();
        for (WinningCount winningCount : WinningCount.values()) {
            this.winningCountMap.put(winningCount, 0);
        }
    }

    public Map<WinningCount, Integer> getWinningCountMap() {
        return winningCountMap;
    }

    public void createStatistics(long matchingNum) {
        if (matchingNum >= 3) {
            WinningCount winningCount = findWinningCount(matchingNum);
            Integer matchingNumCount = winningCountMap.get(winningCount);
            winningCountMap.put(winningCount, matchingNumCount + 1);
        }
    }
}
