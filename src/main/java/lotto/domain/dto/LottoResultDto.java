package lotto.domain.dto;

import java.util.Collections;
import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.Rate;
import lotto.domain.WinningRank;

public class LottoResultDto {

    private final Map<Rank, Integer> resultRank;
    private final Rate rate;

    private LottoResultDto(WinningRank resultRank, Rate rate) {
        this.resultRank = resultRank.getWinningRank();
        this.rate = rate;
    }

    public static LottoResultDto of(WinningRank resultRank, Rate rate) {
        return new LottoResultDto(resultRank, rate);
    }

    public Map<Rank, Integer> getResultRank() {
        return Collections.unmodifiableMap(resultRank);
    }

    public double getRate() {
        return rate.getRate();
    }
}
