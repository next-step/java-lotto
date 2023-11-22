package lotto.ui.dto;

import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.Money;

import java.util.HashMap;
import java.util.Map;

public class LottoStatsResponse {
    private final Map<LottoPrize, LottoStatResponse> lottoStats = new HashMap<>();
    private final float profitRate;

    public LottoStatsResponse(Map<LottoPrize, LottoStatResponse> lottoStats, float profitRate) {
        this.lottoStats.putAll(lottoStats);
        this.profitRate = profitRate;
    }

    public static LottoStatsResponse of(LottoResult lottoResult, Money money) {
        Map<LottoPrize, LottoStatResponse> map = new HashMap<>();
        lottoResult.getStatistics().forEach((lottoPrize, count) -> map.put(lottoPrize,
                new LottoStatResponse(lottoPrize.getMatchCount(),
                        lottoResult.getPrizeCount(lottoPrize),
                        lottoPrize.getMoney())));
        return new LottoStatsResponse(map, lottoResult.getProfitRate(money));
    }

    public Map<LottoPrize, LottoStatResponse> getLottoStats() {
        return lottoStats;
    }

    public float getProfitRate() {
        return profitRate;
    }
}
