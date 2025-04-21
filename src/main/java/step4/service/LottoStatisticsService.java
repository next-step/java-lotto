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
    private final Amount spent;
    private final Map<Rank, Integer> result;

    private LottoStatisticsService(Amount spent, Map<Rank, Integer> result) {
        this.spent = spent;
        this.result = result;
    }

    public static LottoStatisticsService of(LottoOrder order, Map<Rank, Integer> result) {
        return new LottoStatisticsService(order.price(), result);
    }

    /**
     * 수익률 계산: (총 상금 ÷ 사용액) × 100
     */
    public double calculateRate() {
        Amount earned = result.entrySet().stream()
            .map(e -> e.getKey().calculateTotalPrizeByCount(e.getValue()))
            .reduce(new Amount(0), Amount::add);

        // (earned / spent) × 100
        return earned.getAmount()
            .multiply(BigInteger.valueOf(100))
            .divide(spent.getAmount())
            .doubleValue();
    }
}
