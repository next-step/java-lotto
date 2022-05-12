package lotto.domain.result;

import java.util.Objects;

public class LottoGameResult {
    private LottoMatchResults lottoMatchResults;
    private int purchaseAmount;

    public LottoGameResult(int purchaseAmount) {
        this(null, purchaseAmount);
    }

    LottoGameResult(LottoMatchResults lottoMatchResults, int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;

        if (lottoMatchResults == null) {
            this.lottoMatchResults = new LottoMatchResults();
            return;
        }
        this.lottoMatchResults = lottoMatchResults;
    }

    public void addMatchResult(int matchNumber) {
        lottoMatchResults.addMatchNumber(matchNumber);
    }

    long getTotalReward() {
        return lottoMatchResults.getLottoReward();
    }

    public double getYield() {
        return (double) getTotalReward() / purchaseAmount;
    }
    public LottoMatchResults getLottoMatchResults() {
        return lottoMatchResults;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LottoGameResult lottoGameResult = (LottoGameResult) obj;
        return this.lottoMatchResults.equals(lottoGameResult.lottoMatchResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoMatchResults);
    }
}
