package lotto;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {

    private final Map<MatchCount, Integer> winningResult;

    public WinningResult() {
        this.winningResult = new EnumMap<>(MatchCount.class);
    }

    public int countByMatch(MatchCount matchCount) {
        return winningResult.getOrDefault(matchCount, 0);
    }

    public void add(MatchCount matchCount) {
        winningResult.put(matchCount, winningResult.getOrDefault(matchCount, 0) + 1);
    }
}
