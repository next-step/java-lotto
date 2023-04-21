package step2;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {

    private static final String RESULT_DELIMITER = "\n";

    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LottoResult lottoResult : lottoResults) {
            builder.append(lottoResult.toString())
                    .append(RESULT_DELIMITER);
        }
        return builder.toString();
    }

    public List<Integer> countNumOfWinner(List<Integer> winNumbers) {
        return lottoResults.stream()
                .map(lottoResult -> lottoResult.countMatchingNumbers(winNumbers))
                .collect(Collectors.toList());
    }
}
