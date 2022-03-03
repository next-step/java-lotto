package lotto.domain.result;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class WinningStatistics {

    private final BigDecimal profitRate;

    public WinningStatistics(Map<LottoResult, Integer> numberOfResults, int money) {
        this.profitRate = applyProfitRate(numberOfResults, money);
    }

    public BigDecimal applyProfitRate(Map<LottoResult, Integer> result, int money) {
        BigDecimal totalWinning = BigDecimal.valueOf(0);

        for (LottoResult lottoResult : result.keySet()) {
            final BigDecimal value = BigDecimal.valueOf(result.get(lottoResult));
            totalWinning = totalWinning.add(value.multiply(BigDecimal.valueOf(lottoResult.getReward())));
        }

        return totalWinning.divide(BigDecimal.valueOf(money), 2, RoundingMode.FLOOR);
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }
}
