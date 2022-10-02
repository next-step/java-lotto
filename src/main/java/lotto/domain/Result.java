package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<Integer, WinResult> winResultMap = new HashMap<>();

    public void saveResult(int matchingCount) {
        winResultMap.putIfAbsent(matchingCount, new WinResult(matchingCount));
        winResultMap.get(matchingCount).addWinCount();
    }

    public Map<Integer, WinResult> getWinResultMap() {
        return winResultMap;
    }

    public class WinResult {
        private final int matchingCount;
        private int winCount = 0;

        private WinResult(int matchingCount) {
            this.matchingCount = matchingCount;
        }

        public int getMatchingCount() {
            return matchingCount;
        }

        public int getWinCount() {
            return winCount;
        }

        private void addWinCount() {
            this.winCount++;
        }
    }

}
