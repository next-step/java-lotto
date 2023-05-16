package lotto.domain.result;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResults {
    public List<LottoResult> lottoResults;

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

    public Map<Rank, Long> groupingByLottoResult() {
        return lottoResults.stream().collect(Collectors.groupingBy(LottoResult::getKey, Collectors.summingLong(LottoResult::getValue)));
    }

    @Override
    public String toString() {
        return "LottoResults{" + "lottoResults=" + lottoResults + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }
}
