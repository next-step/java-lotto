package lotto.domain;

import java.util.Map;

public class EarningRate {

    private final double rate;

    public EarningRate(LottoMatcher lottoMatcher, LottoMoney lottoMoney) {
        this.rate = calculateRate(lottoMoney, sumWinningMoney(lottoMatcher.getRankResult()));
    }

    private double calculateRate(LottoMoney lottoMoney, double winningMoney) {
         return winningMoney / lottoMoney.money;
    }

    private long sumWinningMoney(Map<LottoRank, Integer> rankResult) {
        long winningMoney = 0;
        for (LottoRank lottoRank : rankResult.keySet()) {
            winningMoney += LottoRank.calculateWinningMoney(lottoRank, rankResult.get(lottoRank));
        }
        return winningMoney;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return String.format("%.2f", rate);
    }
}
