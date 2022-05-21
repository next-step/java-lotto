package lotto.domain.result;

import java.util.Objects;
import lotto.domain.LottoReward;

public class LottoGameResult {
    private LottoMatchResults lottoMatchResults;
    private PurchaseAmount purchaseAmount;

    public LottoGameResult(int purchaseAmount) {
        this(null, purchaseAmount);
    }

    LottoGameResult(LottoMatchResults lottoMatchResults, int purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);

        if (lottoMatchResults == null) {
            this.lottoMatchResults = new LottoMatchResults();
            return;
        }
        this.lottoMatchResults = lottoMatchResults;
    }

    public void addMatchResult(LottoReward lottoReward) {
        lottoMatchResults.addMatchNumber(lottoReward);
    }

    long getTotalReward() {
        return lottoMatchResults.getLottoReward();
    }

    public double getYield() {
        return purchaseAmount.yield(getTotalReward());
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
