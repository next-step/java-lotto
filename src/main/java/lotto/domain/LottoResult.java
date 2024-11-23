package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final RankResult rankResult;
    private final double earningRate;

    public LottoResult(RankResult rankResult, double earningRate) {
        this.rankResult = rankResult;
        this.earningRate = earningRate;
    }

    public LottoResult(Map<Rank, Integer> rankFrequency, double earningRate) {
        this(new RankResult(rankFrequency), earningRate);
    }

    public Integer of(Rank rank) {
        return rankResult.of(rank);
    }

    public double getEarningRate() {
        return earningRate;
    }
}
