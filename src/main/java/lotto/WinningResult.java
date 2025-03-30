package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningResult {

    private final Map<Integer, Integer> winningResult;

    public WinningResult() {
        this.winningResult = new HashMap<>();
    }

    public int countByMatch(int matchesNumber) {
        return winningResult.getOrDefault(matchesNumber, 0);
    }

    public void add(int matchCount) {
        winningResult.put(matchCount, winningResult.getOrDefault(matchCount, 0) + 1);
    }
}
