package lotto.dto;

import lotto.LottoRank;

import java.util.Map;

public class LottoResultResponseDto {
    private final Map<LottoRank, Long> lottoResults;
    private final double profitRate;

    public LottoResultResponseDto(Map<LottoRank, Long> lottoResults, double profitRate) {
        this.lottoResults = lottoResults;
        this.profitRate = profitRate;
    }

    public Map<LottoRank, Long> getLottoResults() {
        return lottoResults;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
