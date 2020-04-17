package Lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int DEFAULT_COUNT = 0;
    private final Map<WinningType, Integer> results = new HashMap<>();

    public LottoResult() {
        for (WinningType type : WinningType.values()) {
            results.put(type, DEFAULT_COUNT);
        }
    }

    public void insertResult(final WinningType winningType) {
        this.results.put(winningType, this.results.get(winningType) + 1);
    }
}
