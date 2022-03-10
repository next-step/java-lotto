package lotto.domain.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfResults {

    private final Map<LottoResult, Integer> numberOfResults = new HashMap<>();

    public NumberOfResults(List<LottoResult> lottoResults) {
        applyNumberOfResults(lottoResults);
    }

    private static boolean hasReward(LottoResult lottoResult) {
        return lottoResult != LottoResult.NO_REWARD;
    }

    private void applyNumberOfResults(List<LottoResult> lottoResults) {
        lottoResults.stream()
                .filter(NumberOfResults::hasReward)
                .forEach(lottoResult -> numberOfResults.put(lottoResult,
                        numberOfResults.getOrDefault(lottoResult, 0) + 1));
    }

    public Map<LottoResult, Integer> getNumberOfResults() {
        return new HashMap<>(numberOfResults);
    }
}
