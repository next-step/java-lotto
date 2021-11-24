package com.kakao.lotto.supportInfo;

import com.kakao.lotto.domain.LottoRank;

import java.util.Collections;
import java.util.Map;

public class RankStatistic {
    private final Map<LottoRank, Integer> rankCount;
    private final double profit;

    public RankStatistic(Map<LottoRank, Integer> usersRankCount, int inputMoney) {
        this.rankCount = usersRankCount;
        this.profit = calculateProfitRate(inputMoney);
    }

    private double calculateProfitRate(int inputMoney) {
        Integer profit = rankCount.entrySet().stream()
                .map(this::calculateRankProfit)
                .reduce(0, Integer::sum);
        return profitFormula(inputMoney, profit);
    }

    private Integer calculateRankProfit(Map.Entry<LottoRank, Integer> rankCountEntity) {
        return rankCountEntity.getKey().getPrice() * rankCountEntity.getValue();
    }

    private double profitFormula(int beforeMoney, int nowMoney) {
        return (double) nowMoney / beforeMoney;
    }

    public Map<LottoRank, Integer> getRankCount() {
        return Collections.unmodifiableMap(rankCount);
    }

    public double getProfit() {
        return profit;
    }
}
