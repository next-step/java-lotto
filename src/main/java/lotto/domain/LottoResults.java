package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoResults {
    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public double calculateYield(int investment) {
        return (double) getTotalReward() / investment;
    }

    public int getTotalReward() {
        return lottoResults.stream()
                .map(lottoResult -> lottoResult.getReward())
                .mapToInt(lottoResult -> lottoResult)
                .sum();
    }

    public List<LottoResult> getLottoResults(){
        return lottoResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResults that = (LottoResults) o;

        return (int)lottoResults.stream()
                .filter(lottoResult -> that.lottoResults.contains(lottoResult))
                .count() == (int)that.lottoResults.stream().count();
    }
}
