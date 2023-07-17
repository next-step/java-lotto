package lotto.domain.statistics;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class LottoResults {

    private final List<LottoResult> lottoResults;

    public LottoResults(final Map<LottoMatch, Integer> resultMap) {
        lottoResults = Arrays.stream(LottoMatch.values())
            .filter((lottoMatch -> !lottoMatch.equals(LottoMatch.NONE_MATCH)))
            .map((lottoMatch -> new LottoResult(lottoMatch, resultMap)))
            .collect(Collectors.toList());
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }
}
