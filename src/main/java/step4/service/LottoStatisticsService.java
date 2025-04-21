package step4.service;

import java.math.BigInteger;
import java.util.Map;

import step4.domain.Amount;
import step4.domain.LottoOrder;
import step4.domain.Rank;

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
        Amount spend = order.price();
        Amount earn = calculateTotalCount();
        return earn.getAmount()
            .multiply(BigInteger.valueOf(100))
            .divide(spend.getAmount())
            .doubleValue();
    }

    public Amount calculateTotalCount() {
        return result.entrySet()
            .stream()
            .map(this::calculateTotalPrize)
            .reduce(new Amount(0), Amount::add);
    }

    private Amount calculateTotalPrize(Map.Entry<Rank, Integer> entry) {
        return entry.getKey().calculateTotalPrizeByCount(entry.getValue());
    }
}
