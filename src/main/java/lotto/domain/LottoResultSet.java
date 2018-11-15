package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResultSet {

    private List<LottoResult> lottoResults;

    private LottoResultSet(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResultSet create(List<LottoResult> lottoResults) {
        return new LottoResultSet(lottoResults);
    }

    public int reward() {
        return lottoResults.stream()
                .mapToInt(LottoResult::reward)
                .sum();
    }

    @Override
    public String toString() {
        return lottoResults.stream()
                .map(LottoResult::toString)
                .collect(Collectors.joining("\n"));
    }
}
