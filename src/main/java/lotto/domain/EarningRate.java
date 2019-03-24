package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class EarningRate {

    private final double rate;

    public EarningRate(LottoMatcher lottoMatcher, LottoMoney lottoMoney) {
        long winningMoney = sumWinningMoney(lottoMatcher.rankResult);
        this.rate = (double) winningMoney / lottoMoney.money;
    }

    private long sumWinningMoney(Map<LottoRank, Integer> rankResult) {
        long winningMoney = 0;
        for (LottoRank lottoRank : rankResult.keySet()) {
            winningMoney += lottoRank.money * rankResult.get(lottoRank);
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
