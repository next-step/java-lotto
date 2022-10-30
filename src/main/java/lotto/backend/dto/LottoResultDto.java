package lotto.backend.dto;

import lotto.backend.domain.LottoRank;
import lotto.backend.domain.LottoResult;

import java.util.Collections;
import java.util.Map;

public class LottoResultDto {

    private final Map<LottoRank, Integer> ranking;
    private final double profit;

    public LottoResultDto(Map<LottoRank, Integer> ranking, double profit) {
        this.ranking = ranking;
        this.profit = profit;
    }

    public static LottoResultDto of(LottoResult lottoResult) {
        return new LottoResultDto(lottoResult.getLottoStatistics(), lottoResult.getProfit());
    }

    public double getProfit() {
        return profit;
    }

    public Map<LottoRank, Integer> getRanking() {
        return Collections.unmodifiableMap(ranking);
    }
}
