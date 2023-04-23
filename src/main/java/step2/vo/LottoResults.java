package step2.vo;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {

    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }

    public List<Integer> countNumOfWinner(List<Integer> winNumbers) {
        return lottoResults.stream()
                .map(lottoResult -> lottoResult.countMatchingNumbers(winNumbers))
                .collect(Collectors.toList());
    }
}
