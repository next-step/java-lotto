package lotto.dto;

import lotto.domain.LottoRank;
import lotto.domain.LottoResults;

import java.util.Map;

public class LottoResultResponseDto {

    private final Map<LottoRank, Long> lottoResults;
    private final double profitRate;

    public LottoResultResponseDto(LottoResults lottoResults, double profitRate) {
        this.lottoResults = lottoResults.getLottoResults();
        this.profitRate = profitRate;
    }

    public Map<LottoRank, Long> getLottoResults() {
        return lottoResults;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
