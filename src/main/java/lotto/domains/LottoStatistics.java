package lotto.domains;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<Integer,LottoStatistic> statisticsMap = new HashMap<>();

    public LottoStatistics() {
        for (int i = 0; i < 7; i++) {
            statisticsMap.put(i, new LottoStatistic());
        }
    }

    public int count(int key) {
        return statisticsMap.get(key).count();
    }

    public void add(int key) {
        statisticsMap.get(key).add();
    }

    public int totalPayout() {
        return statisticsMap.values()
                .stream()
                .map(LottoStatistic::payout)
                .reduce(0, Integer::sum);
    }
}
