package domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResults {
    public static final int MINIMUM_HIT_NUMBER = 3;

    private List<LottoResult> lottoResults;

    public LottoResults() {
        this.lottoResults = Arrays.stream(Prize.values())
                .map(it -> new LottoResult(it, 0))
                .collect(Collectors.toList());
    }

    public void win(long hitNumber) {
        if (hitNumber < MINIMUM_HIT_NUMBER) {
            return;
        }

        for (LottoResult result : lottoResults) {
            result.winning(hitNumber);
        }
    }

    public int getTotalPrizeMoney() {
        return lottoResults.stream()
                .map(LottoResult::calculateWinningMoney)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public List<LottoResult> getLottoResults() {
        return Collections.unmodifiableList(this.lottoResults);
    }
}
