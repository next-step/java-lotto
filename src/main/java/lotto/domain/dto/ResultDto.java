package lotto.domain.dto;

import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

public class ResultDto {

    private final Map<Rank, Integer> resultRank;
    private final Double yield;

    private ResultDto(WinningResult resultRank, Double yield) {
        this.resultRank = resultRank.getResult();
        this.yield = yield;
    }

    public static ResultDto of(WinningResult resultRank, Double yield) {
        return new ResultDto(resultRank, yield);
    }

    public Map<Rank, Integer> getResultRank() {
        return resultRank;
    }

    public Double getYield() {
        return yield;
    }
}
