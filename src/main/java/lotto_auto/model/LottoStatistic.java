package lotto_auto.model;

import java.util.List;

public class LottoStatistic {
    private LottoResultList lottoResultList;
    private final double yield;

    public LottoStatistic(List<LottoResult> lottoResultList) {
        this.lottoResultList = new LottoResultList(lottoResultList);
        this.yield = computeYield(lottoResultList);
    }

    private double computeYield(List<LottoResult> lottoResultList) {
        long sum = lottoResultList.stream()
                .filter(LottoResult::isWinning)
                .mapToLong(LottoResult::getMoney)
                .sum();
        return (double) sum / (lottoResultList.size() * LottoTicket.PRICE);
    }

    public int getRankLottoCount(int rank) {
        return lottoResultList.getRankLottoCount(rank);
    }

    public double getYield() {
        return this.yield;
    }
}
