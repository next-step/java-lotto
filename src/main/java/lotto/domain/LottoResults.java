package lotto.domain;

import java.util.List;

public class LottoResults {

    private static final String EMPTY_LOTTO_RESULTS_EXCEPTION_MESSAGE = "당첨 결과가 비어있어 통계를 낼 수 없습니다.";

    private final List<WinningCriteria> lottoResults;

    public LottoResults(final List<WinningCriteria> lottoResults) {
        validate(lottoResults);
        this.lottoResults = lottoResults;
    }

    private void validate(final List<WinningCriteria> lottoResults) {
        if (lottoResults == null || lottoResults.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LOTTO_RESULTS_EXCEPTION_MESSAGE);
        }
    }

    public List<WinningCriteria> getLottoResults() {
        return lottoResults;
    }
}
