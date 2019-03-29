package domain;

import util.WinType;

import java.util.Map;

public class LottoResult {
    private Money money;
    private Map<WinType, Long> resultMap;

    LottoResult(int money, Map<WinType, Long> result) {
        this.money = Money.of(money);
        this.resultMap = result;
    }

    LottoResult(Money money, Map<WinType, Long> result) {
        this.money = money;
        this.resultMap = result;
    }

    public long countWin(WinType type) {
        Long count = resultMap.get(type);
        return count != null ? count : 0;
    }

    public float getYield() {
        return money.getYield(getWinMoney());
    }

    private Money getWinMoney() {
        return Money.of(resultMap.entrySet().stream()
                .mapToInt(it -> it.getKey().calculatePrize(it.getValue()))
                .sum());
    }
}
