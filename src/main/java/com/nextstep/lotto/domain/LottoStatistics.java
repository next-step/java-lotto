package com.nextstep.lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private static final int ZERO = 0;
    private int totalCount = 0;
    private final Map<LottoWinning, Integer> result = new HashMap<>();

    public void addCount(LottoWinning lottoWinning) {
        int count = 0;
        if (result.containsKey(lottoWinning)) {
            count = result.get(lottoWinning);
        }
        result.put(lottoWinning, count + 1);
        totalCount++;
    }

    public int getCount(LottoWinning lottoWinning) {
        if (result.containsKey(lottoWinning)) {
            return result.get(lottoWinning);
        }
        return 0;
    }

    public double profitRate() {
        if (result.isEmpty()) {
            return ZERO;
        }

        int totalPrice = totalCount * LottoSeller.LOTTO_PRICE;
        double totalProfit = getTotalProfit();
        double profitRate = totalProfit / totalPrice;
        return new BigDecimal(profitRate).setScale(2, RoundingMode.DOWN).doubleValue();
    }

    private double getTotalProfit() {
        return result.entrySet().stream().mapToDouble(entry -> {
            LottoWinning lottoWinning = entry.getKey();
            int count = entry.getValue();
            return (double)lottoWinning.getWinningPrice() * count;
        }).sum();
    }
}
