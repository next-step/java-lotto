package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoAggregator {

    private Map<LottoRank, Integer> lottoResult;

    public LottoAggregator() {
        lottoResult = new EnumMap<>(LottoRank.class);
    }

    public void put(LottoRank rank) {
        Integer count = lottoResult.getOrDefault(rank, 0);
        lottoResult.put(rank, ++count);
    }

    public int get(LottoRank rank) {
        return lottoResult.getOrDefault(rank, 0);
    }

    public double getRateOfReturn() {
        int totalReturnMoney = getTotalReturnMoney();
        int orderMoney = getOrderMoney();
        return totalReturnMoney / orderMoney;
    }

    private int getTotalReturnMoney() {
        return lottoResult.keySet().stream()
                .mapToInt(rank -> rank.getPrizeMoney() * this.get(rank))
                .sum();
    }

    private int getBoughtCount() {
        return lottoResult.keySet().stream()
                .mapToInt(this::get)
                .sum();
    }

    private int getOrderMoney() {
        return Order.UNIT_PRICE * getBoughtCount();
    }
}
