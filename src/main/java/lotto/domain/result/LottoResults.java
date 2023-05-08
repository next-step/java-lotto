package lotto.domain.result;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {
    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResults of() {
        return new LottoResults(Arrays.stream(Rank.values())
                .map(LottoResult::of)
                .collect(Collectors.toList()));
    }

    public void win(int hitCount) {
        for (LottoResult lottoResult : lottoResults) {
            lottoResult.win(hitCount);
        }
    }

    public List<LottoResult> getLottoResults() {
        return Collections.unmodifiableList(this.lottoResults);
    }

    @Override
    public String toString() {
        return "LottoResults{" +
                "lottoResults=" + lottoResults +
                '}';
    }
}
