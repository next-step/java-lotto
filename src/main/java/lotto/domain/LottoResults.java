package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoResults {

    private static final int ZERO = 0;
    private static final int DECIMAL_PLACE = 2;

    private final Map<Ranking, Integer> totalResult;

    public LottoResults(final Map<Ranking, Integer> totalResult) {
        this.totalResult = totalResult;
        initializeTotalResult(totalResult);
    }

    private void initializeTotalResult(final Map<Ranking, Integer> totalResult) {
        Arrays.stream(Ranking.values())
            .forEach(ranking -> totalResult.put(ranking, ZERO));
    }

    public void updateResults(final Ranking ranking) {
        Integer currentCount = totalResult.get(ranking);
        totalResult.put(ranking, ++currentCount);
    }

    public BigDecimal calculateYield(final Money money) {
        final List<Ranking> rankings = new ArrayList<>(totalResult.keySet());

        final BigDecimal totalWinnerPrize = BigDecimal.valueOf(rankings.stream()
            .mapToInt(ranking ->
                ranking.multiplyCountAndWinnerPrice(totalResult.get(ranking)))
            .sum());

        return totalWinnerPrize.divide(BigDecimal.valueOf(money.getMoney()), DECIMAL_PLACE,
            RoundingMode.HALF_UP);
    }

    public Map<Ranking, Integer> getTotalResult() {
        return Collections.unmodifiableMap(totalResult);
    }
}
