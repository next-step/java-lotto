package domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResults {
    public static final int MINIMUM_HIT_NUMBER = 3;

    private List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResults of() {
        return new LottoResults(Arrays.stream(Rank.values())
                .map(LottoResult::of)
                .collect(Collectors.toList()));
    }

    public void win(long hitNumber) {
        if (hitNumber < MINIMUM_HIT_NUMBER) {
            return;
        }

        for (LottoResult result : lottoResults) {
            result.win(hitNumber);
        }
    }

    public int getTotalPrizeMoney() {
        return lottoResults.stream()
                .map(LottoResult::calculateWinningMoney)
                .reduce(0, Integer::sum);
    }

    public List<LottoResult> getLottoResults() {
        return Collections.unmodifiableList(this.lottoResults);
    }
}
