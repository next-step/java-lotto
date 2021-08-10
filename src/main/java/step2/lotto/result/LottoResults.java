package step2.lotto.result;

import java.util.List;
import java.util.stream.Stream;

public class LottoResults {

    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public Stream<LottoResult> stream() {
        return lottoResults.stream();
    }

    public long sumOfPrizeMoney() {
        return lottoResults.stream()
                .mapToLong(lottoResult -> lottoResult.getLottoPrize().getPrizeMoney())
                .sum();
    }
}
