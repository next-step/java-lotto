package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Integer> winningStatistics;

    public WinningStatistics(Map<Rank, Integer> rankMap) {
        this.winningStatistics = new HashMap<>(rankMap);
    }

    public Map<Rank, Integer> getWinningStatistics() {
        return Collections.unmodifiableMap(winningStatistics);
    }

}
