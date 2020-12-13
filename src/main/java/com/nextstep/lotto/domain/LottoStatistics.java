package com.nextstep.lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private final Map<LottoWinning, Integer> result = new HashMap<>();

    public LottoStatistics(List<LottoWinning> lottoWinnings) {
        if (lottoWinnings == null || lottoWinnings.isEmpty()) {
            throw new IllegalArgumentException("empty value is invalid");
        }
        lottoWinnings.forEach(this::addCount);
    }

    private void addCount(LottoWinning lottoWinning) {
        int count = 0;
        if (result.containsKey(lottoWinning)) {
            count = result.get(lottoWinning);
        }
        result.put(lottoWinning, count + 1);
    }

    public int getCount(LottoWinning lottoWinning) {
        if (result.containsKey(lottoWinning)) {
            return result.get(lottoWinning);
        }
        return 0;
    }

    public double profitRate() {
        int totalPrice = getTotalCount() * LottoSeller.LOTTO_PRICE;
        double totalProfit = getTotalProfit();
        double profitRate = totalProfit / totalPrice;
        return new BigDecimal(profitRate).setScale(2, RoundingMode.DOWN).doubleValue();
    }

    private int getTotalCount() {
        return result.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private double getTotalProfit() {
        return result.entrySet().stream().mapToDouble(entry -> {
            LottoWinning lottoWinning = entry.getKey();
            int count = entry.getValue();
            return (double)lottoWinning.getWinningPrice() * count;
        }).sum();
    }
}
