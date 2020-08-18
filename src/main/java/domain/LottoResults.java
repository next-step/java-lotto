package domain;

import java.util.*;
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

    public void win(int hitNumber, boolean matchBonus) {
        for (LottoResult result : lottoResults) {
            result.win(hitNumber, matchBonus);
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
