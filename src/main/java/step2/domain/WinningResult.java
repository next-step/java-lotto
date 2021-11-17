package step2.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResult {
    private static final int ADD_COUNT = 1;

    private final Map<WinningType, Integer> winningResult = new LinkedHashMap<>();

    private WinningResult() {
        for (WinningType type : WinningType.values()) {
            winningResult.put(type, 0);
        }
    }

    public static WinningResult create() {
        return new WinningResult();
    }

    public void addCount(WinningType type) {
        Integer matchCount = winningResult.get(type);
        winningResult.put(type, matchCount + ADD_COUNT);
    }

    public Map<WinningType, Integer> getWinningResult() {
        return winningResult;
    }
}
