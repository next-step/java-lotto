package lotto.domain.dto;

import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.Rate;
import lotto.domain.WinningRank;

public class ResultDto {

    private final Map<Rank, Integer> resultRank;
    private final Rate rate;

    private ResultDto(WinningRank resultRank, Rate rate) {
        this.resultRank = resultRank.getWinningRank();
        this.rate = rate;
    }

    public static ResultDto of(WinningRank resultRank, Rate rate) {
        return new ResultDto(resultRank, rate);
    }

    public Map<Rank, Integer> getResultRank() {
        return resultRank;
    }

    public double getRate() {
        return rate.getRate();
    }
}
