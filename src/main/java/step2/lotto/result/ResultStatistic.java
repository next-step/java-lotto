package step2.lotto.result;

public class ResultStatistic {

    private final double totalRevenueRate;
    private final LottoResults lottoResults;

    public ResultStatistic(double totalRevenueRate, LottoResults lottoResults) {
        this.totalRevenueRate = totalRevenueRate;
        this.lottoResults = lottoResults;
    }

    public long countOfMatches(long countOfMatches) {
        return lottoResults.stream()
                .filter(lottoResult -> lottoResult.getCountOfMatches() == countOfMatches)
                .count();
    }

    public double getTotalRevenueRate() {
        return totalRevenueRate;
    }
}
