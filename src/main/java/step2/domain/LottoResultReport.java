package step2.domain;

import java.util.stream.IntStream;

public class LottoResultReport {

    private static final int MINIMUM_MATH_COUNT = 3;
    private static final int MAXIMUM_MATH_COUNT_EXCLUSIVE = 7;
    private static final int DEFAULT_LOTTO_PRICE = 1000;

    private int[] lottoResultReport;

    public LottoResultReport() {
        lottoResultReport = new int[MAXIMUM_MATH_COUNT_EXCLUSIVE];
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
        long cost = gameCount * DEFAULT_LOTTO_PRICE;
        System.out.println("수익률: " + profit + "  비용: " + cost);
        return calculateProfitRate(profit, cost);
    }

    long sum(int[] lottoReport) {
        System.out.println();
        return IntStream.range(MINIMUM_MATH_COUNT, MAXIMUM_MATH_COUNT_EXCLUSIVE)
                .mapToLong(i -> PrizeMoney.toPrizeMoney(i) * lottoReport[i]).sum();
    }

    double calculateProfitRate(long profit, long cost) {
        double rate = (profit - cost) * 1.0 / cost;
        return Math.round(rate * 100) / 100.0;
    }


}
