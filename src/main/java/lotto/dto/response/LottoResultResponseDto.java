package lotto.dto.response;

import lotto.domain.LottoRank;
import lotto.domain.LottoResults;
import lotto.domain.ProfitRate;

import java.util.Map;

public class LottoResultResponseDto {

    private final Map<LottoRank, Long> lottoResults;
    private final double profitRate;

    public LottoResultResponseDto(LottoResults lottoResults, ProfitRate profitRate) {
        this.lottoResults = lottoResults.getLottoResults();
        this.profitRate = profitRate.getProfitRate();
    }

    public Map<LottoRank, Long> getLottoResults() {
        return lottoResults;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
