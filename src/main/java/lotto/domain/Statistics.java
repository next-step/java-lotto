package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private final LottoRanks lottoRanks;
    private final Map<LottoRank, Integer> rankCounts;

    public Statistics(LottoRanks lottoRanks) {
        this.lottoRanks = lottoRanks;
        this.rankCounts = new LinkedHashMap<LottoRank, Integer>() {
            {
                put(LottoRank.FIRST, 0);
                put(LottoRank.SECOND, 0);
                put(LottoRank.THIRD, 0);
                put(LottoRank.FOURTH, 0);
                put(LottoRank.FIFTH, 0);
            }
        };
    }

    public RankCounts getRankCounts() {
        lottoRanks.get()
            .forEach(rank -> {
                if (rank != LottoRank.FAIL) {
                    rankCounts.put(rank, rankCounts.get(rank) + 1);
                }
            });
        return new RankCounts(rankCounts);
    }

    public double getProfitRate() {
        List<LottoRank> lottoRanks = this.lottoRanks.get();
        return lottoRanks.stream().mapToDouble(LottoRank::getAmount).sum() / lottoRanks.size();
    }
}
