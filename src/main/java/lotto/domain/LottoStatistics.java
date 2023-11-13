package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private static final int LOTTO_MIN_MATCH_COUNT = 3;

    public List<LottoWinResult> statistics(Map<Long, Long> lottoResult) {
        List<LottoWinResult> lottoResults = new ArrayList<>();
        lottoResult.entrySet().stream()
                .filter(entry -> entry.getKey() >= LOTTO_MIN_MATCH_COUNT)
                .forEach(entry -> lottoResults.add(new LottoWinResult(entry.getKey(), entry.getValue())));
        return lottoResults;
    }

}
