package com.kakao.lotto.domain;

import com.kakao.lotto.supportInfo.PurchaseInfo;
import com.kakao.lotto.supportInfo.WinResult;

import java.util.Map;

public class RankStatistic {
    private final Map<LottoRank, Integer> rankCount;

    public RankStatistic(Map<LottoRank, Integer> usersRankCount) {
        this.rankCount = usersRankCount;
    }

    public WinResult createWinResult(PurchaseInfo purchaseInfo){
        return new WinResult(rankCount, calculateProfitRate(purchaseInfo));
    }

    public double calculateProfitRate(PurchaseInfo purchaseInfo) {
        Integer profit = rankCount.entrySet().stream()
                .map(RankStatistic::calculateRankProfit)
                .reduce(0, Integer::sum);
        return profitFormula(purchaseInfo.getMoney(), profit);
    }

    private static Integer calculateRankProfit(Map.Entry<LottoRank, Integer> rankCountEntity) {
        return rankCountEntity.getKey().getPrice() * rankCountEntity.getValue();
    }

    private double profitFormula(int beforeMoney, int nowMoney) {
        return (double) nowMoney / beforeMoney;
    }
}
