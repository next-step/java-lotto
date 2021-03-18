package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> winningNumberCountMap;

    public LottoResult() {
        winningNumberCountMap = new HashMap<>();
    }

    public void increase(int winningNumberCount) {
        if (winningNumberCountMap.containsKey(winningNumberCount) == false) {
            winningNumberCountMap.put(winningNumberCount, 0);
        }

        int currentMatchCount = winningNumberCountMap.get(winningNumberCount) + 1;
        winningNumberCountMap.put(winningNumberCount, currentMatchCount);
    }

    public int winningNumberCount(int numberOfWinning) {
        try {
            return winningNumberCountMap.get(numberOfWinning);
        } catch (Exception e) {
            return 0;
        }
    }
}
