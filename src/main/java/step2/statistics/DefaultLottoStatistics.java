package step2.statistics;

import java.util.HashMap;
import java.util.Map;

import step2.lotto.Lottos;

import static step2.lotto.Lottos.MATCH_NUMBER_COUNT_TO_WIN;

public class DefaultLottoStatistics implements LottoStatistics {
    private final Map<Integer, Long> priceMap;
    private final Map<Integer, Lottos> lottosMap;

    public DefaultLottoStatistics(final Map<Integer, Lottos> lottosMap) {
        this.priceMap = new HashMap<>();
        this.lottosMap = lottosMap;

        priceMap.put(3, 5_000L);
        priceMap.put(4, 50_000L);
        priceMap.put(5, 1_500_000L);
        priceMap.put(6, 2_000_000_000L);
    }

    public int match(final int bound) {
        return lottosMap.getOrDefault(bound, Lottos.EMTPY).size();
    }

    public long priceSum(final int bound) {
        final long basePrice = lottosMap.getOrDefault(bound, Lottos.EMTPY).priceSum();
        final long winMultiplyFactor = priceMap.getOrDefault(bound, 0L);
        return basePrice * winMultiplyFactor;
    }

    public long priceSum() {
        return MATCH_NUMBER_COUNT_TO_WIN.stream()
                                        .map(this::priceSum)
                                        .mapToLong(Long::longValue)
                                        .sum();
    }
}
