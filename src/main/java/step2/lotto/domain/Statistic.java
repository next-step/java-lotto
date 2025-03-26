package step2.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistic {

    public static final Map<Integer, Integer> PRIZE_MAP = Map.of(
        3, 5000,
        4, 50000,
        5, 1500000,
        6, 2000000000
    );
    private final Map<Integer, Integer> matchCountMap = new HashMap<>();
    private int totalPrize = 0;

    public void calculate(Lottos lottos, Lotto lastWeekLotto) {
        for (Lotto lotto : lottos.getLottos()) {
            int match = lotto.matchCount(lastWeekLotto);
            statistic(match);
        }
    }

    public Map<Integer, Integer> getMatchCountMap() {
        return matchCountMap;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    private void statistic(int match) {
        if (match >= 3) {
            matchCountMap.put(match, matchCountMap.getOrDefault(match, 0) + 1);
            totalPrize += PRIZE_MAP.get(match);
        }
    }
}
