package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoResults {

    private static final int DECIMAL_POINT_PLACE = 2;

    private final Map<Ranking, Integer> totalResult;

    public LottoResults(final Map<Ranking, Integer> totalResult) {
        this.totalResult = totalResult;
    }

    public BigDecimal calculateYield(final Money money) {
        final List<Ranking> rankings = new ArrayList<>(totalResult.keySet());

        final BigDecimal totalWinnerPrize = BigDecimal.valueOf(rankings.stream()
            .mapToInt(ranking ->
                ranking.multiplyCountAndWinnerPrice(totalResult.get(ranking)))
            .sum());

        return totalWinnerPrize.divide(BigDecimal.valueOf(money.getMoney()), DECIMAL_POINT_PLACE,
            RoundingMode.HALF_UP);
    }

    public Map<Ranking, Integer> getTotalResult() {
        return Collections.unmodifiableMap(totalResult);
    }
}
