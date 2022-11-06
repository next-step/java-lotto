package lotto.backend.domain;

import java.util.Collections;
import java.util.Map;

public class LottoResult {

    private final LottoStatistics lottoStatistics;
    private final LottoProfit lottoProfit;

    public LottoResult(LottoStatistics lottoStatistics, LottoProfit lottoProfit) {
        this.lottoStatistics = lottoStatistics;
        this.lottoProfit = lottoProfit;
    }

    public double getProfit() {
        return lottoProfit.getValue();
    }

    public Map<LottoRank, Integer> getLottoStatistics() {
        return Collections.unmodifiableMap(lottoStatistics.getValues());
    }
}
