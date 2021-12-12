package lotto.domain;

import java.util.List;

public class Calculator {
    private final float earnRate;
    private final LottoResults lottoResults;

    public Calculator(LottoResults lottoResults, int purchaseAmount) {
        this.lottoResults = lottoResults;
        this.earnRate = Math.round(lottoResults.totalEarnMoney() / purchaseAmount * 100) / 100.F;
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults.getLottoResults();
    }

    public float getEarnRate() {
        return earnRate;
    }
}
