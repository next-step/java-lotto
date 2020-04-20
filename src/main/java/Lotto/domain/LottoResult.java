package Lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LottoResult {
    private static final int DEFAULT_COUNT = 0;
    private final Map<WinningType, Integer> results = new TreeMap<>();

    public LottoResult() {
        for (WinningType type : WinningType.values()) {
            results.put(type, DEFAULT_COUNT);
        }
    }

    public Map<WinningType, Integer> getResults() {
        return results;
    }

    public void insertResult(final WinningType winningType) {
        this.results.put(winningType, this.results.get(winningType) + 1);
    }

    public float getEarningRate(final Money money) {
        float totalEarningMoney = 0f;
        for (WinningType type : results.keySet()) {
            totalEarningMoney += results.get(type) * type.getWinningMoney();
        }
        return totalEarningMoney / money.getAmount();
    }
}
