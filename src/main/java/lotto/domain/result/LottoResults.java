package lotto.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResults {
    public final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResults of() {
        return new LottoResults(Arrays.stream(Rank.values()).map(LottoResult::of).collect(Collectors.toList()));
    }

    public void win(Rank rank) {
        for (LottoResult lottoResult : lottoResults) {
            lottoResult.win(rank);
        }
    }

    public Map<Rank, Integer> groupingByLottoResult() {
        return lottoResults.stream().collect(Collectors.groupingBy(LottoResult::getKey, Collectors.summingInt(LottoResult::getValue)));
    }

    @Override
    public String toString() {
        return "LottoResults{" + "lottoResults=" + lottoResults + '}';
    }
}
