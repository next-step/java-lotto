package step2.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import step2.lotto.Lotto;

public class DefaultLottoStatistics implements LottoStatistics {
    private final Map<Integer, Integer> priceMap;
    private final Map<Integer, List<Lotto>> rawData;

    public DefaultLottoStatistics(final Map<Integer, List<Lotto>> rawData) {
        this.priceMap = new HashMap<>();
        this.rawData = rawData;

        priceMap.put(3, 5000);
        priceMap.put(4, 50000);
        priceMap.put(5, 1500000);
        priceMap.put(6, 2000000000);
    }

    public int match(final int bound) {
        return rawData.getOrDefault(bound, new ArrayList<>()).size();
    }

    public int priceSum(final int bound) {
        return rawData.getOrDefault(bound, new ArrayList<>())
                      .stream()
                      .map(Lotto::getPrice)
                      .mapToInt(Integer::intValue)
                      .map(val -> val * priceMap.get(bound))
                      .sum();
    }
}
