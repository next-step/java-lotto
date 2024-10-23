package lotto;

import java.util.Map;
import java.util.Objects;

import static lotto.LottoRank.*;
import static lotto.LottoRank.FIRST;

public class LottoResults {

    private final Map<LottoRank, Integer> lottoResults;

    public LottoResults(Map<LottoRank, Integer> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public int firstPrize() {
        return lottoResults.get(LottoRank.FIRST);
    }

    public int secondPrize() {
        return lottoResults.get(LottoRank.SECOND);
    }

    public int thirdPrize() {
        return lottoResults.get(LottoRank.THIRD);
    }

    public int fourthPrize() {
        return lottoResults.get(LottoRank.FOURTH);
    }

    public int fifthPrize() {
        return lottoResults.get(LottoRank.FIFTH);
    }

    public int calculateWinningPrize() {
        return fifthPrize() * FIFTH.getPrize() + fourthPrize() * FOURTH.getPrize() + thirdPrize() * THIRD.getPrize() + firstPrize() * FIRST.getPrize();
    }

    public double calculateProfitability(int amount, int winningPrize) {
        return (double) winningPrize / amount;
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
