package study.lotto.step2.domain;

import java.util.List;
import java.util.Objects;

public class LottoResults {
    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public long winningAmount() {
        return lottoResults.stream()
                .mapToLong(LottoResult::payout)
                .sum();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoResults)) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }
}
