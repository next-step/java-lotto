package com.kakao.lotto.supportInfo;

import com.kakao.lotto.domain.LottoRank;

import java.util.Map;

public class WinResult {
    private final Map<LottoRank, Integer> rankCount;
    private final double profit;

    public WinResult(Map<LottoRank, Integer> rankCount, double profit) {
        this.rankCount = rankCount;
        this.profit = profit;
    }

    public Map<LottoRank, Integer> getRankCount() {
        return rankCount;
    }

    public double getProfit() {
        return profit;
    }
}
