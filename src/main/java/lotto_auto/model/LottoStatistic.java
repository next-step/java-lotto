package lotto_auto.model;

import java.util.List;

public class LottoStatistic {
    private LottoResultList lottoResultList;
    private final double yield;

    public LottoStatistic(List<LottoResult> lottoResultList) {
        this.lottoResultList = new LottoResultList(lottoResultList);
        this.yield = yield(lottoResultList);
    }

    private double yield(List<LottoResult> lottoResultList) {
        long sum = lottoResultList.stream()
                .filter(LottoResult::isWinning)
                .mapToLong(LottoResult::getMoney)
                .sum();
        return (double) sum / (this.lottoResultList.size() * 1000);
    }

    public int getRankLottoCount(int rank) {
        return lottoResultList.getRankLottoCount(rank);
    }

    public double getYield() {
        return this.yield;
    }
}
