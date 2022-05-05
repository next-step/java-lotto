package lotto.domain.result;

import java.util.Objects;

public class LottoGameResult {
    private LottoMatchResults lottoMatchResults;

    public LottoGameResult() {
        this(null);
    }

    LottoGameResult(LottoMatchResults lottoMatchResults) {
        if (lottoMatchResults == null) {
            this.lottoMatchResults = new LottoMatchResults();
            return;
        }

        this.lottoMatchResults = lottoMatchResults;
    }

    public void addMatchResult(int matchNumber) {
        lottoMatchResults.addMatchNumber(matchNumber);
    }

    int getTotalReward() {
        return lottoMatchResults.getLottoReward();
    }

    double getYield(int purchaseAmount) {
        return (double) getTotalReward() / purchaseAmount;
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
