package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Long> lottoResult;

    public LottoResult(Map<LottoRank, Long> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public List<LottoWinResult> lottoStatistics() {
        List<LottoWinResult> lottoWinResults = new ArrayList<>();
        lottoResult.entrySet().stream()
                .filter(entry -> entry.getKey() != LottoRank.MISS)
                .forEach(entry -> lottoWinResults.add(new LottoWinResult(entry.getKey().getMatchCount(), entry.getValue(), entry.getKey().isBonus())));
        return lottoWinResults;
    }

    public Map<LottoRank, Long> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
