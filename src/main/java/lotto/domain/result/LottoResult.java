package lotto.domain.result;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class LottoResult {
    private final Map<Integer, Integer> lottoStatistics;

    public LottoResult(Map<Integer, Integer> lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }

    public int getNumberOfHitTickets(final int hitCount) {
        Integer numberOfHitTickets = lottoStatistics.get(hitCount);
        return Objects.isNull(numberOfHitTickets) ? 0 : numberOfHitTickets;
    }

    public double getRateOfProfit(final int spentMoney) {
        long totalProfit = LottoPrize.calculateTotalReword(lottoStatistics);
        return (double) totalProfit / spentMoney;
    }

    public Map<Integer, Integer> getLottoStatistics() {
        return Collections.unmodifiableMap(lottoStatistics);
    }
}
