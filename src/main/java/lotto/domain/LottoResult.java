package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> result;

    private final Money money;

    public LottoResult(final List<Rank> ranks, final Money money) {
        Map<Rank, Integer> map = new EnumMap<>(Rank.class);
        for (Rank rank : ranks) {
            initMap(map, rank);
        }
        this.result = map;
        this.money = money;
    }

    private void initMap(final Map<Rank, Integer> map, final Rank rank) {
        int x = 1;
        if (map.containsKey(rank)) {
            x = map.get(rank) + 1;
        }
        map.put(rank, x);
    }

    public float calculateRateOfReturn() {
        float sumResult = 0;
        for (Map.Entry<Rank, Integer> entry : this.result.entrySet()) {
            sumResult += entry.getKey().totalMoney(entry.getValue());
        }
        return this.money.rateOfReturn(sumResult);
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
