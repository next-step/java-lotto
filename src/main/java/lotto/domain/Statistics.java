package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.dto.ResultDto;
import lotto.domain.vo.RankCounts;

public class Statistics {

    private final Map<LottoRank, Integer> rankCounts;
    private final double profitRate;

    public Statistics(final LottoRanks lottoRanks) {
        this.rankCounts = rankStatistics(lottoRanks.get());
        this.profitRate = profitStatistics(lottoRanks.getAmounts());
    }

    private Map<LottoRank, Integer> rankStatistics(final List<LottoRank> lottoRanks) {
        Map<LottoRank, Integer> rankCounts = new LinkedHashMap<>();

        Arrays.stream(LottoRank.values()).forEach(rank ->
                rankCounts.put(rank, rankCounts.getOrDefault(rank, 0)
                        + (int) lottoRanks.stream()
                        .filter(resultRank -> rank == resultRank)
                        .count())
        );

        return rankCounts;
    }

    private double profitStatistics(final List<Integer> amounts) {
        double profit = amounts.stream().mapToDouble(a -> a).sum();
        double budget = (amounts.size() * 1000);

        return  profit / budget;
    }

    public ResultDto getResult() {
        return new ResultDto(new RankCounts(this.rankCounts), this.profitRate);
    }
}
