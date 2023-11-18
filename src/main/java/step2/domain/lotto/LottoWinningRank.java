package step2.domain.lotto;

import java.util.HashMap;
import java.util.Map;

import static step2.domain.lotto.WinningCount.findWinningCount;

public class LottoWinningRank {

    private Map<WinningCount, Integer> winningCountMap;

    public LottoWinningRank() {
        this.winningCountMap = new HashMap<>();
        for (WinningCount winningCount : WinningCount.values()) {
            this.winningCountMap.put(winningCount, 0);
        }
    }

    public Map<WinningCount, Integer> getWinningCountMap() {
        return winningCountMap;
    }

    public void createStatistics(final int matchingCount) {
        WinningCount winningCount = findWinningCount(matchingCount);
        Integer matchingNumCount = winningCountMap.get(winningCount);
        winningCountMap.put(winningCount, matchingNumCount + 1);
    }
}
