package lotto;

import java.util.Map;
import java.util.Objects;

public class LottoResults {

    private final Map<LottoRankEnum, Integer> lottoResults;

    public LottoResults(Map<LottoRankEnum, Integer> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public int firstPrize() {
        return lottoResults.get(LottoRankEnum.FIRST);
    }

    public int secondPrize() {
        return lottoResults.get(LottoRankEnum.SECOND);
    }

    public int thirdPrize() {
        return lottoResults.get(LottoRankEnum.THIRD);
    }

    public int fourthPrize() {
        return lottoResults.get(LottoRankEnum.FOURTH);
    }

    public int fifthPrize() {
        return lottoResults.get(LottoRankEnum.FIFTH);
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
