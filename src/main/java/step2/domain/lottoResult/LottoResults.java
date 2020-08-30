package step2.domain.lottoResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {
    private static final int MIN_MATCH_NUMBER = 3;
    private List<LottoResult> lottoResults;

    private LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResults of() {
        return new LottoResults(Arrays.stream(WinNumber.values())
                .map(LottoResult::of)
                .collect(Collectors.toList()));
    }

    public void win(int hitCount, boolean matchBonus) {
        for (LottoResult result : lottoResults) {
            result.win(hitCount, matchBonus);
        }
    }

    public int getTotalMoney() {
        return lottoResults.stream()
                .map(LottoResult::winningProfit)
                .reduce(0, Integer::sum);
    }

    public List<LottoResult> getLottoResults() {
        return Collections.unmodifiableList(this.lottoResults);
    }
}
