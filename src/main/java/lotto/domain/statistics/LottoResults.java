package lotto.domain.statistics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {

    private final List<LottoResult> lottoResults;

    public LottoResults(final LottoStatistics lottoStatistics) {
        lottoResults = Arrays.stream(LottoMatch.values())
            .filter((lottoMatch -> !lottoMatch.equals(LottoMatch.NONE_MATCH)))
            .map((lottoMatch -> new LottoResult(lottoMatch, lottoStatistics)))
            .collect(Collectors.toList());
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }
}
