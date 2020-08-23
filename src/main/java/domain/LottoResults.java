package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {

    private List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResults of() {
        return new LottoResults(Arrays.stream(Rank.values())
                .filter(it -> it != Rank.MISS)
                .map(LottoResult::of)
                .collect(Collectors.toList()));
    }

    public void win(Rank rank) {
        for (LottoResult result : lottoResults) {
            result.win(rank);
        }
    }

    public long getTotalPrizeMoney() {
        return lottoResults.stream()
                .mapToLong(LottoResult::getWinningMoney)
                .sum();
    }

    public List<LottoResult> getLottoResults() {
        return Collections.unmodifiableList(this.lottoResults);
    }
}
