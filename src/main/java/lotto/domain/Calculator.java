package lotto.domain;

import java.util.List;

public class Calculator {
    private final float earnRate;
    private final List<LottoResult> lottoResults;

    public Calculator(List<LottoResult> lottoResults, int purchaseAmount) {
        double totalEarnMoney = lottoResults.stream()
                                            .mapToDouble(lottoResult -> lottoResult.sumResult())
                                            .sum();
        this.lottoResults = lottoResults;
        this.earnRate = Math.round(totalEarnMoney / purchaseAmount * 100) / 100.F;
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }

    public float getEarnRate() {
        return earnRate;
    }
}
