package domain;

import util.WinType;

import java.util.Map;

public class LottoResult {
    private long money;
    private Map<WinType, Long> resultMap;

    LottoResult(long money, Map<WinType, Long> result) {
        this.money = money;
        this.resultMap = result;
    }

    public long countWin(WinType type) {
        Long count = resultMap.get(type);
        return count != null ? count : 0;
    }

    public float getYield() {
        return getWinMoney() / money;
    }

    private int getWinMoney() {
        return resultMap.entrySet().stream()
                .mapToInt(it -> it.getKey().calculatePrize(it.getValue()))
                .sum();
    }
}
