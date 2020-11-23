package lotto_auto.model;

import java.util.List;

public class LottoStatistic {
    private LottoResultList lottoResultList;
    private final double yield;
    private final int payment;

    public LottoStatistic(List<LottoResult> lottoResultList, int payment) {
        this.lottoResultList = new LottoResultList(lottoResultList);
        this.yield = computeYield(lottoResultList);
        this.payment = payment;
    }

    private double computeYield(List<LottoResult> lottoResultList) {
        long sum = lottoResultList.stream()
                .filter(LottoResult::isWinning)
                .mapToLong(LottoResult::getMoney)
                .sum();
        return (double) sum / payment;
    }

    public int getRankLottoCount(int rank) {
        return lottoResultList.getRankLottoCount(rank);
    }

    public double getYield() {
        return this.yield;
    }
}
