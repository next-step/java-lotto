package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class WinningRanks {
    private final List<Rank> ranks;

    public WinningRanks(List<Rank> ranks) {
        this.ranks = new ArrayList<>(ranks);
    }

    public double calcProfitRate(LottoPayment lottoPayment) {
        int totalReward = calcTotalReward();
        int buyLottoMoney = lottoPayment.calcLottoBuyQuantity() * LottoPayment.LOTTO_PRICE;
        return new BigDecimal(totalReward).divide(new BigDecimal(buyLottoMoney), 2, RoundingMode.DOWN).doubleValue();
    }

    private int calcTotalReward() {
        int totalReward = 0;
        for (Rank rank : ranks) {
            totalReward += rank.getReward();
        }
        return totalReward;
    }

    public Map<Rank, Integer> aggregateRank() {
        Map<Rank, Integer> aggregationRankMap = new HashMap<>();
        for (Rank rank : ranks) {
            int count = aggregationRankMap.getOrDefault(rank, 0);
            aggregationRankMap.put(rank, count + 1);
        }
        return aggregationRankMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningRanks that = (WinningRanks) o;
        return Objects.equals(ranks, that.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }
}
