package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultSet {

    private static final int DECIMAL_PLACES = 2;

    private List<LottoResult> lottoResults;

    private LottoResultSet(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public static LottoResultSet create(List<LottoResult> lottoResults) {
        return new LottoResultSet(lottoResults);
    }

    public BigDecimal rateReturn(int purchaseAmount) {
        BigDecimal amount = BigDecimal.valueOf(purchaseAmount);
        BigDecimal reward = BigDecimal.valueOf(reward());

        return reward.divide(amount, DECIMAL_PLACES, RoundingMode.DOWN);
    }

    public int reward() {
        return lottoResults.stream()
                .mapToInt(LottoResult::reward)
                .sum();
    }

    @Override
    public String toString() {
        return lottoResults.stream()
                .map(LottoResult::toString)
                .collect(Collectors.joining("\n"));
    }
}
