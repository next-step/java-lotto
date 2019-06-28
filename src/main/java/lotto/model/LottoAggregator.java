package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoAggregator {

    private Map<LottoRank, Integer> lottoResult;

    public LottoAggregator() {
        lottoResult = new EnumMap<>(LottoRank.class);
    }

    public void put(LottoRank rank) {
        Integer count = getCount(rank);
        lottoResult.put(rank, ++count);
    }

    public int getCount(LottoRank rank) {
        return lottoResult.getOrDefault(rank, 0);
    }

    public double getRateOfReturn() {
        Long totalReturnMoney = getTotalReturnMoney();
        int orderMoney = getOrderMoney();
        return totalReturnMoney / orderMoney;
    }

    private Long getTotalReturnMoney() {
        return lottoResult.keySet().stream()
                .mapToLong(rank -> rank.getPrizeMoney() * this.getCount(rank))
                .sum();
    }

    private int getBoughtCount() {
        return lottoResult.keySet().stream()
                .mapToInt(this::getCount)
                .sum();
    }

    private int getOrderMoney() {
        return Order.UNIT_PRICE * getBoughtCount();
    }
}
