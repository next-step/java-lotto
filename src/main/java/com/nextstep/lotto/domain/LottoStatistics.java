package com.nextstep.lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoRank, Integer> result = new HashMap<>();

    public LottoStatistics(List<LottoRank> lottoRanks) {
        if (lottoRanks == null || lottoRanks.isEmpty()) {
            throw new IllegalArgumentException("empty value is invalid");
        }
        lottoRanks.forEach(this::addCount);
    }

    public int getCount(LottoRank lottoRank) {
        if (result.containsKey(lottoRank)) {
            return result.get(lottoRank);
        }
        return 0;
    }

    public double profitRate() {
        int totalPrice = getTotalCount() * LottoSeller.LOTTO_PRICE;
        double totalProfit = getTotalProfit();
        double profitRate = totalProfit / totalPrice;
        return new BigDecimal(profitRate).setScale(2, RoundingMode.DOWN).doubleValue();
    }

    private void addCount(LottoRank lottoRank) {
        int count = 0;
        if (result.containsKey(lottoRank)) {
            count = result.get(lottoRank);
        }
        result.put(lottoRank, count + 1);
    }

    private int getTotalCount() {
        return result.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private double getTotalProfit() {
        return result.entrySet().stream().mapToDouble(entry -> {
            LottoRank lottoRank = entry.getKey();
            int count = entry.getValue();
            return (double) lottoRank.getWinningPrice() * count;
        }).sum();
    }
}
