package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final int LOTTO_MIN_MATCH_COUNT = 3;

    private final Map<Long, Long> lottoResult;

    public LottoResult(Map<Long, Long> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public List<LottoWinResult> lottoStatistics() {
        List<LottoWinResult> lottoResults = new ArrayList<>();
        lottoResult.entrySet().stream()
                .filter(entry -> entry.getKey() >= LOTTO_MIN_MATCH_COUNT)
                .forEach(entry -> lottoResults.add(new LottoWinResult(entry.getKey(), entry.getValue())));
        return lottoResults;
    }

    public Map<Long, Long> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
