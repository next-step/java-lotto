package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private Map<LottoLevels, Integer> map;

    public LottoResult() {
        map = new EnumMap<>(LottoLevels.class);
    }

    public void put(int matchingCount) {
        LottoLevels match = LottoLevels.match(matchingCount);
        Integer count = map.getOrDefault(match, 0);
        map.put(match, ++count);
    }

    public int get(LottoLevels level) {
        return map.getOrDefault(level, 0);
    }

    public double getRateOfReturn() {
        int totalReturnMoney = getTotalReturnMoney();
        int orderMoney = getOrderMoney();
        return totalReturnMoney / orderMoney;
    }

    private int getTotalReturnMoney() {
        return map.keySet().stream()
                .mapToInt(level -> level.getPrizeMoney() * this.get(level))
                .sum();
    }

    private int getBoughtCount() {
        return map.keySet().stream()
                .mapToInt(this::get)
                .sum();
    }

    private int getOrderMoney() {
        return Order.UNIT_PRICE * getBoughtCount();
    }
}
