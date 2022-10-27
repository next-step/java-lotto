package lotto.backend.dto;

import lotto.backend.domain.LottoRank;
import lotto.backend.domain.LottoResult;

import java.util.Map;

public class LottoResultDto {

    private final Map<LottoRank, Integer> ranking;
    private final double profit;

    public LottoResultDto(Map<LottoRank, Integer> ranking, double profit) {
        this.ranking = ranking;
        this.profit = profit;
    }

    public static LottoResultDto from(LottoResult lottoResult) {
        return new LottoResultDto(lottoResult.getLottoStatistics(), lottoResult.getProfit());
    }

    public double findProfit() {
        return profit;
    }

    public int findPrize(int match) {
        return LottoRank.of(match).getPrize();
    }

    public int findMatch(int match) {
        return ranking.getOrDefault(LottoRank.of(match), 0);
    }
}
