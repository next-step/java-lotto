package step2.service;

import java.util.Map;

import step2.domain.LottoOrder;
import step2.domain.Rank;

/**
 * 로또 통계 서비스
 */
public class LottoStatisticsService {
    private final LottoOrder order;
    private final Map<Rank, Integer> result;

    public LottoStatisticsService(LottoOrder order, Map<Rank, Integer> result) {
        this.order = order;
        this.result = result;
    }

    public double calculateRate() {
        int spend = order.lottos().calculateTotal();
        long earn = calculateTotalCount();
        return Math.round(earn * 100 / spend) / 100.0 ;
    }

    public long calculateTotalCount() {
        return result.entrySet()
            .stream()
            .mapToInt((entry) -> {
                return entry.getKey().calculateTotalPrizeByCount(entry.getValue());
            })
            .sum();
    }
}
