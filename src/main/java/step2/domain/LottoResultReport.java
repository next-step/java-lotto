package step2.domain;

import java.util.stream.IntStream;

public class LottoResultReport {

    private int[] lottoResultReport;

    public LottoResultReport() {
        lottoResultReport = new int[LottoCommonValue.MAXIMUM_MATH_COUNT_EXCLUSIVE.value()];
    }

    public LottoResultReport(int[] lottoResultReport) {
        this.lottoResultReport = lottoResultReport;
    }

    public int recordRank(int index) {
        return lottoResultReport[index] += 1;
    }

    public int findReportByMatchCount(int matchCount) {
        return lottoResultReport[matchCount];
    }

    public double calculateProfit(int gameCount) {
        long profit = sum(lottoResultReport);
        long cost = gameCount * LottoCommonValue.DEFAULT_LOTTO_PRICE.value();
        System.out.println("수익률: " + profit + "  비용: " + cost);
        return calculateProfitRate(profit, cost);
    }

    long sum(int[] lottoReport) {
        System.out.println();
        return IntStream.range(LottoCommonValue.MINIMUM_MATH_COUNT_INCLUSIVE.value(),
                        LottoCommonValue.MAXIMUM_MATH_COUNT_EXCLUSIVE.value())
                .mapToLong(i -> PrizeMoney.toPrizeMoney(i) * lottoReport[i]).sum();
    }

    double calculateProfitRate(long profit, long cost) {
        double rate = (profit - cost) * 1.0 / cost;
        return Math.round(rate * 100) / 100.0;
    }


}
