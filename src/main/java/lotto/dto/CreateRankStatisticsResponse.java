package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Rank;
import lotto.domain.RankResult;

public class CreateRankStatisticsResponse {

    private final List<RankResultDto> rankResultDtos;
    private final double yield;

    private CreateRankStatisticsResponse(List<RankResultDto> rankResultDtos, double yield) {
        this.rankResultDtos = rankResultDtos;
        this.yield = yield;
    }

    public static CreateRankStatisticsResponse valueOf(RankResult rankResult, double yield) {
        List<RankResultDto> rankResultDtos = new ArrayList<>();
        for (Entry<Rank, Long> singleRankStatistics : rankResult.getRankStatistics().entrySet()) {
            rankResultDtos.add(RankResultDto.valueOf(singleRankStatistics));
        }
        return new CreateRankStatisticsResponse(rankResultDtos, yield);
    }

    public List<RankResultDto> getRankResultDtos() {
        return rankResultDtos;
    }

    public double getYield() {
        return yield;
    }
}
