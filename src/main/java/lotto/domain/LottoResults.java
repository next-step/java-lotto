package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoResults {

    private final Map<Ranking, Integer> totalResult;

    public LottoResults(final Map<Ranking, Integer> totalResult) {
        this.totalResult = totalResult;
    }

    public BigDecimal calculateYield(final Money money) {
        final List<Ranking> rankings = new ArrayList<>(totalResult.keySet());

        Money totalWinnerPrize = new Money(rankings.stream()
            .mapToInt(ranking ->
                ranking.multiplyCountAndWinnerPrice(totalResult.get(ranking)))
            .sum());

        return totalWinnerPrize.divide(money);
    }

    public Map<Ranking, Integer> getTotalResult() {
        return Collections.unmodifiableMap(totalResult);
    }
}
