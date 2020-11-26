package lotto_auto.model;

import java.util.List;

public class LottoStatistic {
    private BundleDrawResult bundleDrawResult;
    private final double yield;
    private final int payment;

    public LottoStatistic(List<DrawResult> drawResultList, int payment) {
        this.bundleDrawResult = new BundleDrawResult(drawResultList);
        this.payment = payment;
        this.yield = computeYield();
    }

    private double computeYield() {
        long totalMoney = bundleDrawResult.getTotalMoney();
        return (double) totalMoney / payment;
    }

    public int getRankLottoCount(int rank) {
        return bundleDrawResult.getRankLottoCount(rank);
    }

    public double getYield() {
        return this.yield;
    }
}
