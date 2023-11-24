package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.RankResult;

public class RankStatisticsDto {

    private final List<RankResultDto> rankResultDtos;
    private final double yield;

    private RankStatisticsDto(List<RankResultDto> rankResultDtos, double yield) {
        this.rankResultDtos = rankResultDtos;
        this.yield = yield;
    }

    public static RankStatisticsDto valueOf(List<RankResult> rankResults, double yield) {
        List<RankResultDto> rankResultDtos = new ArrayList<>();
        for (RankResult rankResult : rankResults) {
            rankResultDtos.add(RankResultDto.valueOf(rankResult));
        }
        return new RankStatisticsDto(rankResultDtos, yield);
    }

    public List<RankResultDto> getRankResultDtos() {
        return rankResultDtos;
    }

    public double getYield() {
        return yield;
    }
}
