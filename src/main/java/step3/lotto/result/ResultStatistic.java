package step3.lotto.result;

import step3.lotto.Rank;

public class ResultStatistic {

    private final double totalRevenueRate;
    private final LottoResults lottoResults;

    public ResultStatistic(double totalRevenueRate, LottoResults lottoResults) {
        this.totalRevenueRate = totalRevenueRate;
        this.lottoResults = lottoResults;
    }

    public long countOfRank(Rank rank) {
        return lottoResults.stream()
                .filter(lottoResult -> lottoResult.getRank() == rank)
                .count();
    }

    public double getTotalRevenueRate() {
        return totalRevenueRate;
    }
}
