package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoResults {
    private List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public BigDecimal calculateTotalRewardsRatio(int purchasedMoney) {
        BigDecimal totalRewards = lottoResults.stream()
                .map(LottoResult::calculateRewards)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
        return totalRewards.divide(BigDecimal.valueOf(purchasedMoney * 100.0),2, RoundingMode.HALF_EVEN);
    }

    public List<LottoResult> value() {
        return lottoResults;
    }
}
